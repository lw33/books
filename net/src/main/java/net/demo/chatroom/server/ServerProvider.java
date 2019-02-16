package net.demo.chatroom.server;


import net.commons.constants.UDPConstants;
import net.commons.util.ByteUtils;
import net.commons.util.Tools;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
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

    public static void stop() {
        if (PROVIDER != null) {
            PROVIDER.exit();
            PROVIDER = null;
        }
    }

    private static class Provider extends Thread {
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
                System.out.println("ServerProvider started...");
                ds = new DatagramSocket(UDPConstants.SERVER_PORT);
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                while (running) {

                    ds.receive(receivePacket);

                    String clientIP = receivePacket.getAddress().getHostAddress();
                    int clientPort = receivePacket.getPort();
                    int clientDataLen = receivePacket.getLength();
                    byte[] clientData = receivePacket.getData();

                    // 头 口令 端口
                    boolean isValid = clientDataLen >= (UDPConstants.HEADER.length + 2 + 4)
                            && ByteUtils.startsWith(clientData, UDPConstants.HEADER);

                    System.out.println("ServerProvider receive from ip: " + clientIP +
                            "\tport: " + clientPort + "\tdataValid: " + isValid);
                    if (!isValid) {
                        continue;
                    }

                    int index = UDPConstants.HEADER.length;
                    short cmd = (short) ((clientData[index++] << 8) | clientData[index++]);
                    int responsePort = Tools.byteArray2Int(clientData, index, index + 3);

                    // cmd 1 代表搜索
                    if (cmd == 1 && responsePort > 0) {
                        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
                        byteBuffer.put(UDPConstants.HEADER);
                        byteBuffer.putShort((short) 2);
                        byteBuffer.putInt(port);
                        byteBuffer.put(sn);
                        int len = byteBuffer.position();
                        DatagramPacket datagramPacket = new DatagramPacket(buffer, len, receivePacket.getAddress(), responsePort);
                        ds.send(datagramPacket);
                        System.out.println("ServerProvider response to: " + clientIP + "\tport: " + responsePort + "\tdataLen: " + len);
                    } else {
                        System.out.println("ServerProvider receive cmd nonsupport; cmd: " + cmd);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
            System.out.println("ServerProvider Finished...");
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
