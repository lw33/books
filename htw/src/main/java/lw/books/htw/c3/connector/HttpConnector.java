package lw.books.htw.c3.connector;

import lw.books.htw.c3.core.HttpProcessor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2018-12-01 12:33:07
 **/
public class HttpConnector implements Runnable{

    private boolean stopped;
    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!stopped) {
            Socket socket = null;
            HttpProcessor processor = new HttpProcessor(this);
            processor.process(socket);
            try {
                socket = serverSocket.accept();

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
