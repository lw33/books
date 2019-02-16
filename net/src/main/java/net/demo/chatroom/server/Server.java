package net.demo.chatroom.server;

import net.commons.constants.TCPConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lw
 * @Date 2019-01-02 20:56:47
 **/
public class Server {
    public static void main(String[] args) throws IOException {

        TCPServer tcpServer = new TCPServer(TCPConstants.SERVER_PORT);
        boolean isSuccess = tcpServer.start();
        if (!isSuccess) {
            System.out.println("Start TCP Server failed!");
            return;
        }

        ServerProvider.start(TCPConstants.SERVER_PORT);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            s = bufferedReader.readLine();
            tcpServer.broadcast(s);
        } while (!"bbyyee".equalsIgnoreCase(s));
        ServerProvider.stop();
        tcpServer.stop();
    }
}
