package net.demo.tcp_udp.client;

import net.demo.tcp_udp.client.bean.ServerInfo;

/**
 * @Author lw
 * @Date 2019-01-02 21:43:24
 **/
public class Client {

    public static void main(String[] args) throws InterruptedException {
        ServerInfo serverInfo = ClientSearcher.seacherServer(10000);
        System.out.println("Server: " + serverInfo);
        if (serverInfo != null) {
            try {
                TCPClient.linkWith(serverInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
