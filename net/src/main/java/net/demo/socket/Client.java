package net.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2018-12-26 14:39:22
 **/
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();

        socket.setSoTimeout(3000);

        socket.connect(new InetSocketAddress(InetAddress.getByName("localhost"), 8080), 3000);

        System.out.println("connect success...");
        System.out.println(socket.getLocalAddress());
        System.out.println(socket.getRemoteSocketAddress());
        try {
            todo(socket);
        } catch (Exception e) {
            System.out.println("exception");
        }finally {
            socket.close();
            System.out.println("client exit");
        }
    }

    public static void todo(Socket client) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(client.getOutputStream());
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        do {

            String s = bufferedReader.readLine();
            printStream.println(s);
            String echo = socketBufferReader.readLine();
            if ("bye".equalsIgnoreCase(echo)) {
                System.out.println("bye bye...");
                break;
            }
            System.out.println(echo);
            //bufferedReader.close();
            //System.out.println(bufferedReader);
        } while (true);
        socketBufferReader.close();
    }
}
