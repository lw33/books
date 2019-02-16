package net.demo.niochatroom.server.handler;

import lombok.extern.slf4j.Slf4j;
import net.commons.core.Connector;
import net.commons.util.CloseUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2019-01-04 21:23:30
 **/
@Slf4j
public class ClientHandler {

    private SocketChannel socketChannel;
    private ClientReadHandler readHandler;
    private ClientWriteHandler writeHandler;
    private ClientHandlerCallback clientHandlerCallback;
    private String clientInfo;

    public ClientHandler(SocketChannel socketChannel, ClientHandlerCallback clientHandlerCallback) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);

        //Selector readSelector = Selector.open();
        //socketChannel.register(readSelector, SelectionKey.OP_READ);

        //this.readHandler = new ClientReadHandler(readSelector);

        Selector writeSelector = Selector.open();
        socketChannel.register(writeSelector, SelectionKey.OP_WRITE);

        this.writeHandler = new ClientWriteHandler(writeSelector);
        Connector connector = new Connector() {
            @Override
            public void onReceiveNewMessage(String str) {
                clientHandlerCallback.onNewMsgArrived(ClientHandler.this, str);
            }

            @Override
            public void onChannelClosed(SocketChannel channel) {
                exitBySelf();
            }
        };

        connector.setup(socketChannel);

        this.clientHandlerCallback = clientHandlerCallback;
        clientInfo = socketChannel.getRemoteAddress().toString();
        System.out.println("新客户端连接: " + clientInfo);
    }

    public String getClientInfo() {
        return clientInfo;
    }

    public void send(String s) {
        writeHandler.send(s);
    }

    public void exit() {
        readHandler.exit();
        writeHandler.exit();
        CloseUtils.close(socketChannel);
        System.out.println("客户端退出: " + clientInfo);
    }

    public void exitBySelf() {
        exit();
        clientHandlerCallback.onSelfClose(this);
    }

    public void readToPrint() throws IOException {
        readHandler.start();
    }

    public interface ClientHandlerCallback {
        // 自身关闭时通知
        void onSelfClose(ClientHandler clientHandler);

        // 收到消息时通知
        void onNewMsgArrived(ClientHandler clientHandler, String msg);
    }

    class ClientReadHandler extends Thread {

        private boolean running = true;
        private Selector selector;
        private ByteBuffer byteBuffer;

        public ClientReadHandler(Selector selector) {
            this.selector = selector;
            byteBuffer = ByteBuffer.allocate(256);
        }

        public void run() {
            try {
                do {
                    if (selector.select() == 0) {
                        if (running) {
                            continue;
                        }
                        break;
                    }

                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();

                        if (key.isReadable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            byteBuffer.clear();
                            int read = channel.read(byteBuffer);
                            if (read > 0) {

                                // 打印收到的数据
                                // 丢弃换行
                                String s = new String(byteBuffer.array(), 0, byteBuffer.position() - 1);

                                clientHandlerCallback.onNewMsgArrived(ClientHandler.this, s);

                            } else {
                                System.out.println("client can not read data...");
                                ClientHandler.this.exitBySelf();
                                break;
                            }
                        }
                    }

                } while (running);
            } catch (Exception e) {
                if (running) {
                    log.error("连接异常断开...");
                    ClientHandler.this.exitBySelf();
                }
            } finally {
                CloseUtils.close(selector);
            }
        }

        void exit() {
            running = false;
            selector.wakeup();
            CloseUtils.close(selector);
        }
    }

    class ClientWriteHandler {
        private boolean running = true;
        private ExecutorService executorService;
        private Selector selector;
        private ByteBuffer byteBuffer;

        public ClientWriteHandler(Selector selector) {
            executorService = Executors.newSingleThreadExecutor();
            this.selector = selector;
            byteBuffer = ByteBuffer.allocate(256);
        }


        public void send(String s) {
            s += "\n";

            if (running) {
                String msg = s;
                executorService.submit(() -> {
                    try {
                        /*if (selector.select() == 0) {
                            if (running) {
                                if (selector.select() == 0) {
                                    if (!running) {
                                        return;
                                    }
                                }
                            }
                        }
                        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            iterator.remove();
                            if (key.isWritable()) {
                                SocketChannel channel = (SocketChannel) key.channel();

                                channel.write(byteBuffer);
                            }
                        }*/
                        if (!running) {
                            return;
                        }
                        byteBuffer.clear();
                        byteBuffer.put(msg.getBytes());
                        byteBuffer.flip();
                        while (running && byteBuffer.hasRemaining()) {
                            int len = socketChannel.write(byteBuffer);
                            if (len < 0) {
                                System.out.println("客户端已无法发送数据！");
                                ClientHandler.this.exitBySelf();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        void exit() {
            running = false;
            CloseUtils.close(selector);
            executorService.shutdownNow();
        }
    }

    public ClientHandler() {

    }

}
