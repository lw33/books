package net.tcp;

import java.io.IOException;
import java.net.*;

/**
 * @Author lw
 * @Date 2019-01-02 18:24:08
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = createServerSocket();
        initServerSocket(serverSocket);

        System.out.println("Server start...");
        while (true) {
            Socket socket = serverSocket.accept();
            net.socket.Server.ClientHandler clientHandler = new net.socket.Server.ClientHandler(socket);
            clientHandler.start();
        }

    }


    public static ServerSocket createServerSocket() throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), Client.port), 50);
        return serverSocket;
    }

    private static void initServerSocket(ServerSocket serverSocket) throws SocketException {
        serverSocket.setReuseAddress(true);

        serverSocket.setReceiveBufferSize(Client.BUFFER);
        //serverSocket.setSoTimeout(2000);

        serverSocket.setPerformancePreferences(1, 1, 1);
    }
}
