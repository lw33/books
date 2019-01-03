package net.c5.client;

import net.c5.client.bean.ServerInfo;

/**
 * @Author lw
 * @Date 2019-01-02 21:43:24
 **/
public class Client {

    public static void main(String[] args) {
        ServerInfo serverInfo = ClientSearcher.seacherServer(10000);
        System.out.println("Server: " + serverInfo);
    }
}
