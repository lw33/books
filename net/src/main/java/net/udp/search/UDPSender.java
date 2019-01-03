package net.udp.search;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author lw
 * @Date 2018-12-26 17:58:29
 **/
public class UDPSender {

    private static final int LISTEN_PORT = 3000;

    public static void main(String[] args) throws Exception {

        System.out.println("UDPSender start...");
        Listener listener = listen();
        sendBroadcast();
        System.in.read();
        List<Device> deviceAndClose = listener.getDeviceAndClose();
        System.out.println(deviceAndClose);
        System.out.println("UDPSender finished...");
    }

    private static Listener listen() throws InterruptedException {
        System.out.println("UDPSender listen start...");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(LISTEN_PORT, countDownLatch);
        listener.start();
        countDownLatch.await();
        return listener;
    }

    private static void sendBroadcast() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("UDPSender sendBroadcast start...");
        final byte[] bytes = new byte[1024];
        String request = MessageCreator.buildWithPort(LISTEN_PORT);
        DatagramPacket datagramPacket = new DatagramPacket(request.getBytes(), request.length());
        datagramPacket.setPort(8088);
        //datagramPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        //datagramPacket.setAddress(InetAddress.getByName("localhost"));
        datagramPacket.setAddress(InetAddress.getLocalHost());
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
        System.out.println("UDPSender sendBroadcast finished...");
    }

    static class Device {
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
        private final CountDownLatch countDownLatch;
        private DatagramSocket ds;
        private boolean done;
        private List<Device> devices = new ArrayList<>();

        public Listener(int listenPort, CountDownLatch countDownLatch) {
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                ds = new DatagramSocket(listenPort);
                countDownLatch.countDown();
                while (!done) {

                    byte[] buffer = new byte[128];
                    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

                    ds.receive(datagramPacket);

                    String ip = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    int length = datagramPacket.getLength();
                    String data = new String(datagramPacket.getData(), 0, length);
                    System.out.println("UDPSearcher receive from ip: " + ip + "\tport:" + port + "\tdata:" + data);
                    String sn = MessageCreator.parseSN(data);
                    if (sn != null) {
                        Device device = new Device(ip, port, sn);
                        devices.add(device);
                    }
                }
            } catch (Exception e) {

            } finally {
                close();
            }
        }

        private void close() {
            if (ds != null) {
                System.out.println("UDPSender listen stop...");
                ds.close();
                ds = null;
            }
        }

        public List<Device> getDeviceAndClose() {
            done = true;
            close();

            return devices;
        }
    }
}
