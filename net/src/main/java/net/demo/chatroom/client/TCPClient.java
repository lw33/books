package net.demo.chatroom.client;

import lombok.extern.slf4j.Slf4j;
import net.commons.util.CloseUtils;
import net.demo.chatroom.client.bean.ServerInfo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;


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
            ClientReadHandler readHandler = new ClientReadHandler(socket.getInputStream());
            readHandler.start();
            write(socket);

            readHandler.exit();
        } catch (Exception e) {
            log.error("异常关闭");
        }
        socket.close();
        log.info("client exit...");
    }

    private static void write(Socket socket) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        do {
            String s = bufferedReader.readLine();
            printStream.println(s);
            if ("bye".equals(s)) {
                break;
            }
        } while (true);
        printStream.close();
    }

    static class ClientReadHandler extends Thread {

        private boolean running = true;
        private final InputStream inputStream;

        public ClientReadHandler(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public void run() {
            BufferedReader bufferReader = null;
            try {
                bufferReader = new BufferedReader(new InputStreamReader(inputStream));
                do {
                    String s;
                    try {
                        s = bufferReader.readLine();
                    } catch (SocketTimeoutException e) {
                        continue;
                    }
                    if (s == null) {
                        System.out.println("client can not read data...");
                        break;
                    }
                    System.out.println(s);
                } while (running);
            } catch (Exception e) {
                if (running) {
                    log.error("连接异常断开...");
                }
            } finally {
                CloseUtils.close(bufferReader);
            }
        }

        void exit() {
            running = false;
            CloseUtils.close(inputStream);
        }
    }

}
