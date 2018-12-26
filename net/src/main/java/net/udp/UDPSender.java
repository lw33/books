package net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author lw
 * @Date 2018-12-26 17:58:29
 **/
public class UDPSender {

    public static void main(String[] args) throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("UDPSender start...");
        final byte[] bytes = new byte[1024];
        String request = "hello";
        DatagramPacket datagramPacket = new DatagramPacket(request.getBytes(), request.length());
        datagramPacket.setPort(8088);
        datagramPacket.setAddress(InetAddress.getLocalHost());
        datagramSocket.send(datagramPacket);
        //DatagramPacket datagramPacket2 = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData()));
        System.out.println("UDPSender finished...");
    }
}
