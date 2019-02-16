package net.commons.impl;

import net.commons.core.IOProvider;
import net.commons.util.CloseUtils;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lw
 * @Date 2019-02-10 15:17:43
 **/
public class IOSelectorProvider implements IOProvider {
    private final AtomicBoolean isClosed = new AtomicBoolean(false);

    private final AtomicBoolean inInput = new AtomicBoolean(false);
    private final AtomicBoolean inOutput = new AtomicBoolean(false);


    private final Selector readSelector;
    private final Selector writeSelector;

    private final ExecutorService inputHandlePool;
    private final ExecutorService outputHandlePool;

    // 记录 selectionkey 与 回调
    private final Map<SelectionKey, Runnable> inputCallbackMap = new HashMap<>();
    private final Map<SelectionKey, Runnable> outputCallbackMap = new HashMap<>();

    public IOSelectorProvider() throws IOException {

        readSelector = Selector.open();
        writeSelector = Selector.open();

        inputHandlePool = Executors.newFixedThreadPool(4,
                new IOProviderThreadFactory("IOProvider-Input-Thread-"));
        outputHandlePool = Executors.newFixedThreadPool(4,
                new IOProviderThreadFactory("IOProvider-Output-Thread-"));

        startRead();

        startWrite();
    }

    private void startRead() {
        Thread thread = new Thread("IOSelectorProvider ReadSelector Thread") {

            @Override
            public void run() {

                while (!isClosed.get()) {
                    try {

                        if (readSelector.select() == 0) {
                            waitSelection(inInput);
                            continue;
                        }

                        Set<SelectionKey> selectionKeys = readSelector.selectedKeys();
                        for (SelectionKey selectionKey : selectionKeys) {
                            if (selectionKey.isValid()) {
                                handleSelection(selectionKey, SelectionKey.OP_READ, inputCallbackMap, inputHandlePool);
                            }
                        }
                        selectionKeys.clear();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }


    private void startWrite() {
        Thread thread = new Thread("IOSelectorProvider ReadSelector Thread") {

            @Override
            public void run() {

                while (!isClosed.get()) {
                    try {

                        if (writeSelector.select() == 0) {
                            waitSelection(inOutput);
                            continue;
                        }

                        Set<SelectionKey> selectionKeys = writeSelector.selectedKeys();
                        for (SelectionKey selectionKey : selectionKeys) {
                            if (selectionKey.isValid()) {
                                handleSelection(selectionKey, SelectionKey.OP_WRITE, outputCallbackMap, outputHandlePool);
                            }
                        }
                        selectionKeys.clear();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    @Override
    public boolean registerInput(SocketChannel channel, HandleInputCallback callback) {

        return register(channel, readSelector, SelectionKey.OP_READ, inInput, inputCallbackMap, callback) != null;
    }

    @Override
    public boolean registerOutput(SocketChannel channel, HandleOutputCallback callback) {
        return register(channel, writeSelector, SelectionKey.OP_WRITE, inOutput, outputCallbackMap, callback) != null;
    }

    @Override
    public void unRegisterInput(SocketChannel channel) {
        unRegister(channel, readSelector, inputCallbackMap);
    }

    @Override
    public void unRegisterOutput(SocketChannel channel) {
        unRegister(channel, writeSelector, outputCallbackMap);
    }

    @Override
    public void close() throws IOException {
        if (isClosed.compareAndSet(false, true)) {

            inputHandlePool.shutdown();
            outputHandlePool.shutdown();

            inputCallbackMap.clear();
            outputCallbackMap.clear();

            readSelector.wakeup();
            writeSelector.wakeup();

            CloseUtils.close(readSelector, writeSelector);
        }
    }

    private void waitSelection(AtomicBoolean lock) {
        synchronized (lock) {
            if (lock.get()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private SelectionKey register(SocketChannel channel, Selector selector,
                                  int registerOps, AtomicBoolean lock,
                                  Map<SelectionKey, Runnable> callBackMap,
                                  Runnable runnable) {
        synchronized (lock) {
            lock.set(true);
            try {
                selector.wakeup();
                SelectionKey selectionKey = null;
                if (channel.isRegistered()) {
                    selectionKey = channel.keyFor(selector);
                    if (selectionKey != null) {
                        selectionKey.interestOps(selectionKey.readyOps() | registerOps);
                    }
                }

                if (selectionKey == null) {
                    selectionKey = channel.register(selector, registerOps);
                    callBackMap.put(selectionKey, runnable);
                }
                return selectionKey;
            } catch (ClosedChannelException e) {
                e.printStackTrace();
                return null;
            } finally {
                lock.set(false);
                try {
                    lock.notify();
                } catch (Exception ignored) {

                }
            }
        }

    }

    private void unRegister(SocketChannel channel, Selector selector,
                            Map<SelectionKey, Runnable> callBackMap) {
        if (channel.isRegistered()) {
            SelectionKey key = channel.keyFor(selector);
            if (key != null) {
                key.cancel();
                callBackMap.remove(key);
                selector.wakeup();
            }
        }
    }

    /**
     * @param key         对对应的 selectionKey 进行处理
     * @param keyOps      处理的类型
     * @param callbackMap
     * @param handlePool
     */
    private void handleSelection(SelectionKey key, int keyOps,
                                 Map<SelectionKey, Runnable> callbackMap,
                                 ExecutorService handlePool) {
        key.interestOps(key.readyOps() & ~keyOps);
        Runnable runnable = callbackMap.get(key);
        if (runnable != null && !handlePool.isShutdown()) {
            handlePool.execute(runnable);
        }

    }

    /**
     * thread factory
     */
    static class IOProviderThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        IOProviderThreadFactory(String namePrefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            this.namePrefix = namePrefix;
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

}
