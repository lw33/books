package net.demo.chatroom.server.handler;

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
    private final ClientHandlerCallback clientHandlerCallback;
    private final String clientInfo;

    public ClientHandler(Socket socket, ClientHandlerCallback clientHandlerCallback) throws IOException {
        this.socket = socket;
        this.readHandler = new ClientReadHandler(socket.getInputStream());
        this.writeHandler = new ClientWriteHandler(socket.getOutputStream());
        this.clientHandlerCallback = clientHandlerCallback;
        clientInfo = "A[" + socket.getInetAddress().getHostAddress() + "] P[" + socket.getPort() + "]";
        System.out.println("新客户端连接: " + clientInfo);
    }

    public String getClientInfo() {
        return clientInfo;
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
        clientHandlerCallback.onSelfClose(this);
    }

    public void readToPrint() throws IOException {
        readHandler.start();
    }

    public interface ClientHandlerCallback {
        // 自身关闭时通知
        void onSelfClose(ClientHandler clientHandler);

        // 收到消息时通知
        void onNewMsgArrived(ClientHandler clientHandler, String msg);
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
                    // 打印收到的数据
                    clientHandlerCallback.onNewMsgArrived(ClientHandler.this, s);

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
        private PrintStream printStream;

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
