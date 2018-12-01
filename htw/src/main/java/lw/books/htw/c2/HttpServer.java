package lw.books.htw.c2;

import lw.books.htw.c2.v2.ServletProcessorV2;
import lw.books.htw.utils.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2018-11-30 20:35:18
 **/
public class HttpServer {


    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.await();
    }

    private void await() {
        ServerSocket serverSocket = null;
        int port = 8080;

        try {
            serverSocket = new ServerSocket(port, 1,InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {

                socket = serverSocket.accept();
                System.out.println(socket);
                input = socket.getInputStream();
                output = socket.getOutputStream();
                Request request = new Request(input);
                request.parse();
                Response response = new Response(output);
                response.setRequest(request);
                if (request.getUri().startsWith("/servlet/")) {
                    //ServletProcessorV1.process(request, response);
                    ServletProcessorV2.process(request, response);
                } else {
                    response.sendStaticResource();
                }
                socket.close();
                shutdown = request.getUri().equals(Constants.SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

}
