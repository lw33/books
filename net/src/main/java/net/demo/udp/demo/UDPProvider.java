package net.demo.udp.demo;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author lw
 * @Date 2018-12-26 17:58:29
 **/
public class UDPProvider {

    public static void main(String[] args) throws Exception {

        // 作为接收者 指定端口
        DatagramSocket datagramSocket = new DatagramSocket(8088);

        // 构建接收实体
        final byte[] bytes = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(bytes, bytes.length);

        System.out.println("UDPProvider start...");

        // 接收
        datagramSocket.receive(receivePacket);

        // 接收者信息
        String ip = receivePacket.getAddress().getHostAddress();
        int port = receivePacket.getPort();
        int length = receivePacket.getLength();
        String data = new String(receivePacket.getData(), 0, length);
        System.out.println("UDPProvider receive from " + ip + " port " + port);
        System.out.println("Data: " + data);
        receivePacket.setData(new StringBuilder(data).reverse().toString().getBytes());
        datagramSocket.send(receivePacket);
        System.out.println("UDPProvider finished");
        datagramSocket.close();

    }
}
