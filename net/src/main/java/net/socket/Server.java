package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2018-12-26 14:39:15
 **/
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println(serverSocket.getLocalSocketAddress());
        for (; ; ) {
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
            clientHandler.start();
        }
    }


    public static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {

                PrintStream printStream = new PrintStream(socket.getOutputStream());
                BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do {

                    String echo = socketBufferReader.readLine();
                    System.out.println(echo);
                    printStream.println(echo);
                    if ("bye".equalsIgnoreCase(echo)) {
                        break;
                    }
                } while (true);
            } catch (Exception e) {

            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
