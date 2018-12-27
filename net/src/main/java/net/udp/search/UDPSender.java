package net.udp.search;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.CountDownLatch;

/**
 * @Author lw
 * @Date 2018-12-26 17:58:29
 **/
public class UDPSender {

    private static final int LISTEN_PORT = 3000;
    public static void main(String[] args) throws Exception {

        System.out.println("UDPSender start...");
        listen();
        sendBroadcast();


    }

    private static void listen() {

    }
    private static void sendBroadcast() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        final byte[] bytes = new byte[1024];
        String request = "hello";
        DatagramPacket datagramPacket = new DatagramPacket(request.getBytes(), request.length());
        datagramPacket.setPort(8088);
        datagramPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        datagramSocket.send(datagramPacket);
        //DatagramPacket datagramPacket2 = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData()));
        System.out.println("UDPSender finished...");
    }

    class Device {
        private String ip;
        private int port;
        private String sn;

        public Device(String ip, int port, String sn) {
            this.ip = ip;
            this.port = port;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "ip='" + ip + '\'' +
                    ", port=" + port +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    private static class Listener extends Thread {
        private final int listenPort;
        private final CountDownLatch countDownLatch ;

        public Listener(int listenPort, CountDownLatch countDownLatch) {
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }
    }
}
