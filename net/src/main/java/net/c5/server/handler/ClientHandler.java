package net.c5.server.handler;

import lombok.extern.slf4j.Slf4j;
import net.util.CloseUtils;

import java.io.*;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2019-01-04 21:23:30
 **/
@Slf4j
public  class ClientHandler {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        System.out.println("新客户端连接: " + socket.getInetAddress() + " P: " + socket.getPort());
    }

    public void run() {
        PrintStream printStream = null;
        BufferedReader socketBufferReader = null;
        try {
            System.out.println("新客户端连接: " + socket.getInetAddress() + " P: " + socket.getPort());
            printStream = new PrintStream(socket.getOutputStream());
            socketBufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            do {
                String echo = socketBufferReader.readLine();
                System.out.println(echo);
                printStream.println(echo);
                if ("bye".equalsIgnoreCase(echo)) {
                    break;
                }
            } while (true);
        } catch (Exception e) {
            log.error("连接异常断开...");
        }  finally {
            try {
                printStream.close();
                socketBufferReader.close();
                socket.close();
            } catch (IOException e) {
                log.error("关闭失败");
            }
        }

    }

    public void send(String s) {

    }

    public void exit() {

    }

    public void exitBySelf() {
        exit();
    }

    public void readToPrint() {
    }

    class ClientReadHandler extends Thread {

        private boolean running = true;
        private final InputStream inputStream;

        public ClientReadHandler(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public void run() {
            BufferedReader bufferReader = null;
            try {
                bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do {
                    String s = bufferReader.readLine();
                    if (s == null) {
                        System.out.println("client can not read data...");
                        ClientHandler.this.exitBySelf();
                        break;
                    }
                    System.out.println(s);
                } while (running);
            } catch (Exception e) {
                if (running) {
                    log.error("连接异常断开...");
                    ClientHandler.this.exitBySelf();
                }
            }  finally {
                CloseUtils.close(bufferReader);
            }
        }

        void exit() {
            running = false;
            CloseUtils.close(inputStream);
        }
    }
}
