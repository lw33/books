package net.demo.niochatroom.server;

import lombok.extern.slf4j.Slf4j;
import net.commons.util.CloseUtils;
import net.demo.niochatroom.server.handler.ClientHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2019-01-04 20:01:55
 **/
@Slf4j
public class TCPServer implements ClientHandler.ClientHandlerCallback {

    private final int port;
    private ClientListener listener;
    // 客户端处理器列表
    private List<ClientHandler> clientHandlerList = new ArrayList<>();

    private final ExecutorService forwardingThreadPoolExecutor;

    private Selector selector;

    private ServerSocketChannel server;

    public TCPServer(int serverPort) {
        port = serverPort;
        // 转发线程池
        forwardingThreadPoolExecutor = Executors.newSingleThreadExecutor();
    }


    public boolean start() {
        try {

            selector = Selector.open();
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            server.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("服务器信息: " + server.getLocalAddress());
            listener = new ClientListener(selector);
            listener.start();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void stop() {
        if (listener != null) {
            listener.exit();
        }
        synchronized (TCPServer.this) {
            clientHandlerList.forEach(ClientHandler::exit);
            clientHandlerList.clear();
        }
        forwardingThreadPoolExecutor.shutdownNow();
    }

    public void broadcast(String s) {

        synchronized (TCPServer.this) {
            clientHandlerList.forEach(clientHandler -> clientHandler.send(s));
        }
    }


    @Override
    public void onSelfClose(ClientHandler clientHandler) {
        synchronized (TCPServer.this) {
            clientHandlerList.remove(clientHandler);
        }

    }

    @Override
    public void onNewMsgArrived(ClientHandler clientHandler, String msg) {
        System.out.println("Received-" + clientHandler.getClientInfo() + ": " + msg);
        forwardingThreadPoolExecutor.submit(() -> {
            synchronized (TCPServer.this) {
                clientHandlerList.forEach(handler -> {
                    if (handler != clientHandler) {
                        handler.send(msg);
                    }
                });
            }
        });
    }

    private class ClientListener extends Thread {
        private boolean running = true;
        private Selector selector;

        public ClientListener(Selector selector) throws IOException {
            this.selector = selector;
        }

        @Override
        public void run() {
            System.out.println("服务器准备就绪....");

            do {
                try {
                    if (selector.select() == 0) {
                        if (running) {
                            continue;
                        }
                        break;
                    }

                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            ClientHandler clientHandler = new ClientHandler(socketChannel, TCPServer.this);
                            //clientHandler.readToPrint();
                            synchronized (TCPServer.this) {
                                clientHandlerList.add(clientHandler);
                            }
                        }
                    }
                } catch (IOException e) {
                    continue;
                }
            } while (running);
        }

        public void exit() {
            running = false;
            CloseUtils.close(selector);
        }
    }


}
