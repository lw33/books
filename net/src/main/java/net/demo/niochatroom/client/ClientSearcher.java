package net.demo.niochatroom.client;

import net.commons.constants.UDPConstants;
import net.commons.util.ByteUtils;
import net.demo.niochatroom.client.bean.ServerInfo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author lw
 * @Date 2019-01-02 21:43:49
 **/
public class ClientSearcher {

    public static final int LISTEN_PORT = UDPConstants.CLIENT_REPONSE_PROT;

    public static ServerInfo seacherServer(int timeout) throws InterruptedException {

        System.out.println("UDPSearcher Started...");
        CountDownLatch receiveLatch = new CountDownLatch(1);
        Listener listener = null;
        try {
            listener = listen(receiveLatch);
            sendBroadcast();
            receiveLatch.await(timeout, TimeUnit.MILLISECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("UDPSearcher Finished...");
        if (listener == null) {
            return null;
        }
        List<ServerInfo> serverAndClose = listener.getServerAndClose();

        return serverAndClose.size() > 0 ? serverAndClose.get(0) : null;

    }

    private static Listener listen(CountDownLatch receiveLatch) throws InterruptedException {
        System.out.println("UDPSearcher listen start...");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(LISTEN_PORT, countDownLatch, receiveLatch);
        listener.start();
        countDownLatch.await();
        return listener;
    }

    private static void sendBroadcast() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("UDPSearcher sendBroadcast start...");

        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(UDPConstants.HEADER);
        byteBuffer.putShort((short) 1);
        byteBuffer.putInt(LISTEN_PORT);
        DatagramPacket datagramPacket = new DatagramPacket(byteBuffer.array(), byteBuffer.position() + 1);
        datagramPacket.setPort(UDPConstants.SERVER_PORT);
        datagramPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
        System.out.println("UDPSearcher sendBroadcast finished...");

    }

    private static class Listener extends Thread {
        private final int listenPort;
        private final CountDownLatch countDownLatch;
        private final CountDownLatch receiveLatch;
        private DatagramSocket ds;
        private List<ServerInfo> serverInfos = new ArrayList<>();
        private final byte[] buffer = new byte[128];
        private final int minLen = UDPConstants.HEADER.length + 2 + 4;
        private boolean running = true;

        public Listener(int listenPort, CountDownLatch countDownLatch, CountDownLatch receiveLatch) {
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
            this.receiveLatch = receiveLatch;
        }

        @Override
        public void run() {
            try {
                countDownLatch.countDown();
                ds = new DatagramSocket(listenPort);
                while (running) {

                    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

                    ds.receive(datagramPacket);

                    String ip = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    int length = datagramPacket.getLength();
                    byte[] data = datagramPacket.getData();

                    // 头 口令 端口
                    boolean isValid = length >= minLen
                            && ByteUtils.startsWith(data, UDPConstants.HEADER);

                    System.out.println("UDPSearcher receive from ip: " + ip +
                            "\tport: " + port + "\tdataValid: " + isValid);

                    if (!isValid) {
                        continue;
                    }
                    ByteBuffer byteBuffer = ByteBuffer.wrap(buffer, UDPConstants.HEADER.length, length - UDPConstants.HEADER.length);
                    short cmd = byteBuffer.getShort();
                    int serverPort = byteBuffer.getInt();
                    if (cmd != 2 || serverPort <= 0) {
                        System.out.println("UDPSearcher receive cmd: " + cmd + "\tserverPort: " + serverPort);
                        continue;
                    }
                    String sn = new String(buffer, minLen, length - minLen);
                    ServerInfo serverInfo = new ServerInfo(sn, serverPort, ip);
                    serverInfos.add(serverInfo);
                    receiveLatch.countDown();
                }
            } catch (Exception e) {

            } finally {
                close();
            }
        }

        private void close() {
            if (ds != null) {
                System.out.println("UDPSearcher listen stop...");
                ds.close();
                ds = null;
            }
        }

        public List<ServerInfo> getServerAndClose() {
            running = false;
            close();
            return serverInfos;
        }
    }

}
