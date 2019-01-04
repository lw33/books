package net.c5.client;

import lombok.extern.slf4j.Slf4j;
import net.c5.client.bean.ServerInfo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * @Author lw
 * @Date 2019-01-04 20:38:44
 **/
@Slf4j
public class TCPClient {

    public static void linkWith(ServerInfo serverInfo) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);

        socket.connect(new InetSocketAddress(InetAddress.getByName(serverInfo.getAddress()), serverInfo.getPort()), 3000);

        System.out.println("connect success...");
        System.out.println(socket.getLocalAddress());
        System.out.println(socket.getRemoteSocketAddress());

        try {
            todo(socket);
        } catch (Exception e) {
            log.error("异常关闭");
        }
        socket.close();
        log.info("client exit...");
    }

    private static void todo(Socket socket) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        do {
            String s = bufferedReader.readLine();
            printStream.println(s);
            String echo = socketBufferReader.readLine();
            System.out.println(echo);
            if ("bye".equals(s)) {
                break;
            }
        } while (true);
        printStream.close();
        socketBufferReader.close();
    }
}
