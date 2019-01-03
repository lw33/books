package net.c5.server;


import net.c5.constants.UDPConstants;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;

/**
 * @Author lw
 * @Date 2019-01-02 20:57:54
 **/
public class ServerProvider {

    private static Provider PROVIDER;

    public static void start(int port) {
        stop();
        String sn = UUID.randomUUID().toString();
        PROVIDER = new Provider(sn, port);
        PROVIDER.start();
    }

    private static void stop() {
        if (PROVIDER != null) {
            PROVIDER.exit();
            PROVIDER = null;
        }
    }

    private static class Provider extends Thread{
        private final byte[] sn;
        private final int port;
        private boolean running = true;
        private DatagramSocket ds = null;
        private final byte[] buffer = new byte[128];

        public Provider(String sn, int port) {
            this.sn = sn.getBytes();
            this.port = port;
        }

        @Override
        public void run() {
            try {

                ds = new DatagramSocket(UDPConstants.SERVER_PORT);
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                while (running) {

                    ds.receive(receivePacket);

                    String clientIP = receivePacket.getAddress().getHostAddress();
                    int clientPort = receivePacket.getPort();
                    int clientDataLen = receivePacket.getLength();
                    byte[] clientData = receivePacket.getData();

                    //clientDataLen >= (UDPConstants.HEADER.length + 2 + 4)
                    //        ;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void exit() {
            running = false;
            close();
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }
    }
}
