package net.demo.tcp_udp.server.handler;

import lombok.extern.slf4j.Slf4j;
import net.commons.util.CloseUtils;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2019-01-04 21:23:30
 **/
@Slf4j
public class ClientHandler {

    private Socket socket;
    private final ClientReadHandler readHandler;
    private final ClientWriteHandler writeHandler;
    private final CloseNotify closeNotify;

    public ClientHandler(Socket socket, CloseNotify closeNotify) throws IOException {
        this.socket = socket;
        this.readHandler = new ClientReadHandler(socket.getInputStream());
        this.writeHandler = new ClientWriteHandler(socket.getOutputStream());
        this.closeNotify = closeNotify;
        System.out.println("新客户端连接: " + socket.getInetAddress() + " P: " + socket.getPort());
    }

    public void send(String s) {
        writeHandler.send(s);
    }

    public void exit() {
        readHandler.exit();
        writeHandler.exit();
        CloseUtils.close(socket);
        System.out.println("客户端退出: " + socket.getInetAddress() + " P: " + socket.getPort());
    }

    public void exitBySelf() {
        exit();
        closeNotify.onSelfClose(this);
    }

    public void readToPrint() throws IOException {
        readHandler.start();
    }

    public interface CloseNotify {
        void onSelfClose(ClientHandler clientHandler);
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
                bufferReader = new BufferedReader(new InputStreamReader(inputStream));
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
            } finally {
                CloseUtils.close(bufferReader);
            }
        }

        void exit() {
            running = false;
            CloseUtils.close(inputStream);
        }
    }

    class ClientWriteHandler {
        private boolean running = true;
        private ExecutorService executorService;
        PrintStream printStream;

        public ClientWriteHandler(OutputStream outputStream) {
            printStream = new PrintStream(outputStream);
            executorService = Executors.newSingleThreadExecutor();
        }


        public void send(String s) {
            if (running) {
                executorService.submit(() -> printStream.println(s));
            }
        }

        void exit() {
            running = false;
            CloseUtils.close(printStream);
            executorService.shutdownNow();
        }
    }
}
