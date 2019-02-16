package net.commons.impl;

import net.commons.core.IOArgs;
import net.commons.core.IOProvider;
import net.commons.core.Receiver;
import net.commons.core.Sender;
import net.commons.util.CloseUtils;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 封装 接收与发送
 * @Author lw
 * @Date 2019-02-10 15:18:14
 **/
public class SocketChannelAdapter implements Sender, Receiver, Closeable {

    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final SocketChannel channel;
    private final IOProvider ioProvider;
    private final OnChannelStatusChangeListener channelStatusChangeListener;

    private IOArgs.IOArgsEventListener receiveIOEventListener;
    private IOArgs.IOArgsEventListener sendIOEventListener;

    public SocketChannelAdapter(SocketChannel channel, IOProvider ioProvider,
                                OnChannelStatusChangeListener channelStatusChangeListener) throws IOException {
        this.channel = channel;
        this.ioProvider = ioProvider;
        this.channelStatusChangeListener = channelStatusChangeListener;
        channel.configureBlocking(false);
    }

    @Override
    public boolean receiveAsync(IOArgs.IOArgsEventListener listener) throws IOException {
        if (isClosed.get()) {
            throw new IOException("current channel is closed...");
        }

        receiveIOEventListener = listener;
        // 通过 ioProvider 对输入进行注册
        return ioProvider.registerInput(channel, inputCallback);
    }

    @Override
    public boolean sendAsync(IOArgs ioArgs, IOArgs.IOArgsEventListener listener) throws IOException {
        if (isClosed.get()) {
            throw new IOException("current channel is closed...");
        }

        outputCallback.setAttach(ioArgs);
        sendIOEventListener = listener;
        // 通过 ioProvider 对输出进行注册
        return ioProvider.registerOutput(channel, outputCallback);
    }

    @Override
    public void close() throws IOException {
        if (isClosed.compareAndSet(false, true)) {
            // 解除注册
            ioProvider.unRegisterInput(channel);
            ioProvider.unRegisterOutput(channel);
            CloseUtils.close(channel);
            // channel 关闭的回调
            channelStatusChangeListener.onChannelClosed(channel);
        }
    }

    private final IOProvider.HandleInputCallback inputCallback = new IOProvider.HandleInputCallback() {

        @Override
        protected void canProviderInput() {
            if (isClosed.get()) {
                return;
            }
            IOArgs ioArgs = new IOArgs();
            IOArgs.IOArgsEventListener receiveIOEventListener = SocketChannelAdapter.this.receiveIOEventListener;
            if (receiveIOEventListener != null) {
                receiveIOEventListener.onStarted(ioArgs);
            }

            try {
                if (ioArgs.read(channel) > 0 && receiveIOEventListener != null) {
                    receiveIOEventListener.onCompleted(ioArgs);
                } else {
                    throw new IOException("can not read any data...");
                }
            } catch (IOException e) {
                CloseUtils.close(SocketChannelAdapter.this);
            }
        }
    };

    private final IOProvider.HandleOutputCallback outputCallback = new IOProvider.HandleOutputCallback() {

        @Override
        protected void canProviderOutput(Object attach) {
            if (isClosed.get()) {
                return;
            }

            sendIOEventListener.onCompleted(null);
        }
    };

    public interface OnChannelStatusChangeListener {

        void onChannelClosed(SocketChannel channel);
    }
}
