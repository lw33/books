package lw.books.htw.c1;

import lw.books.htw.utils.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2018-11-29 17:03:35
 **/
public class HttpServer {


    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.await();
    }

    public void await() {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket;
            InputStream input;
            OutputStream output;
            try {
                socket = serverSocket.accept();
                System.out.println(socket);
                Request request = new Request(socket.getInputStream());
                request.parse();
                Response response = new Response(socket.getOutputStream());
                response.setRequest(request);
                response.sendStaticResource();
                socket.close();
                shutdown = request.getUri().equals(Constants.SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
