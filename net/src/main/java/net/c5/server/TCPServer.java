package net.c5.server;

import lombok.extern.slf4j.Slf4j;
import net.c5.server.handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-04 20:01:55
 **/
@Slf4j
public class TCPServer {

    private final int port;
    private ClientListener mListener;
    private List<ClientHandler> clientHandlerList = new ArrayList<>();
    public TCPServer(int serverPort) {
        port = serverPort;
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
        clientHandlerList.forEach(clientHandler -> clientHandler.exit());
        clientHandlerList.clear();
    }

    public void broadcast(String s) {
        clientHandlerList.forEach(clientHandler -> clientHandler.send(s));
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
                ClientHandler clientHandler = new ClientHandler(client);
                clientHandler.readToPrint();
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
