package net.demo.chatroom.server;

import lombok.extern.slf4j.Slf4j;
import net.demo.chatroom.server.handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2019-01-04 20:01:55
 **/
@Slf4j
public class TCPServer implements ClientHandler.ClientHandlerCallback {

    private final int port;
    private ClientListener mListener;
    // 客户端处理器列表
    private List<ClientHandler> clientHandlerList = new ArrayList<>();

    private final ExecutorService forwardingThreadPoolExecutor;

    public TCPServer(int serverPort) {
        port = serverPort;
        // 转发线程池
        forwardingThreadPoolExecutor = Executors.newSingleThreadExecutor();
    }


    public boolean start() {
        try {
            mListener = new ClientListener(port);
            mListener.start();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void stop() {
        if (mListener != null) {
            mListener.exit();
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
        private ServerSocket serverSocket;
        private boolean running = true;

        public ClientListener(int port) throws IOException {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器信息: " + serverSocket.getInetAddress() + " P: " + serverSocket.getLocalPort());
        }

        @Override
        public void run() {
            System.out.println("服务器准备就绪....");
            do {
                Socket client;
                try {
                    client = serverSocket.accept();
                } catch (IOException e) {
                    continue;
                }
                try {

                    ClientHandler clientHandler = new ClientHandler(client, TCPServer.this);
                    clientHandler.readToPrint();
                    synchronized (TCPServer.this) {
                        clientHandlerList.add(clientHandler);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (running);
        }

        public void exit() {
            running = false;
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
