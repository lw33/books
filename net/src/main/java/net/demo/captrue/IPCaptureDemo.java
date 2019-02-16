package net.demo.captrue;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import org.junit.Test;

import java.io.IOException;


/**
 * @Author lw
 * @Date 2018-12-26 16:29:12
 **/
public class IPCaptureDemo {

    public static void main(String[] args) {
        /*--------------	第一步绑定网络设备       --------------*/
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        for (NetworkInterface n : devices) {
            System.out.println(n.name + "     |     " + n.description);
        }
        System.out.println("-------------------------------------------");

        JpcapCaptor jpcap = null;
        int caplen = 1512;
        boolean promiscCheck = true;

        try {
            jpcap = JpcapCaptor.openDevice(devices[2], caplen, promiscCheck, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*----------第二步抓包-----------------*/
        int i = 0;
        while (i < 10) {
        //while (true){
            Packet packet = jpcap.getPacket();
            System.out.println();
            if (packet instanceof IPPacket && ((IPPacket) packet).version == 4 ) {

                IPPacket ip = (IPPacket) packet;// 强转
                i++;
                System.out.println("版本：IPv4");
                System.out.println("优先权：" + ip.priority);
                System.out.println("区分服务：最大的吞吐量： " + ip.t_flag);
                System.out.println("区分服务：最高的可靠性：" + ip.r_flag);
                System.out.println("长度：" + ip.length);
                System.out.println("标识：" + ip.ident);
                System.out.println("DF:Don't Fragment: " + ip.dont_frag);
                System.out.println("MF:More Fragment: " + ip.more_frag);
                System.out.println("片偏移：" + ip.offset);
                System.out.println("生存时间：" + ip.hop_limit);
                //System.out.println(((ICMPPacket) packet).checksum);
                short i1 = (short) (ip.header[10] << 8 | ip.header[11]);
                System.out.println(short2binary(i1));

                String protocol = "";
                switch ((int) ip.protocol) {
                    case 1:
                        protocol = "ICMP";
                        break;
                    case 2:
                        protocol = "IGMP";
                        break;
                    case 6:
                        protocol = "TCP";
                        break;
                    case 8:
                        protocol = "EGP";
                        break;
                    case 9:
                        protocol = "IGP";
                        break;
                    case 17:
                        protocol = "UDP";
                        break;
                    case 41:
                        protocol = "IPv6";
                        break;
                    case 89:
                        protocol = "OSPF";
                        break;
                    default:
                        break;
                }
                System.out.println("协议：" + protocol);
                System.out.println("源IP " + ip.src_ip.getHostAddress());
                System.out.println("目的IP " + ip.dst_ip.getHostAddress());
                System.out.println("源主机名： " + ip.src_ip);
                System.out.println("目的主机名： " + ip.dst_ip);
                System.out.println("----------------------------------------------");
            }
        }
    }

    public static String short2binary(short num) {
        StringBuilder sb = new StringBuilder();
        //while (num > 0) {
        for (int i = 0; i < 16; i++) {
            sb.insert(0, num & 1);
            num >>>= 1;
        }
        return sb.toString();
    }
    public static String byte2binary(byte num) {
        StringBuilder sb = new StringBuilder();
        //while (num > 0) {
        for (int i = 0; i < 8; i++) {
            sb.insert(0, num & 1);
            num >>>= 1;
        }
        return sb.toString();
    }
    @Test
    public void test() {
        byte i1 = -1;
        System.out.println(byte2binary(i1));
        byte i2 = -25;
        short i = (short) ((short) i1 << 8);
        System.out.println(i);
        System.out.println(short2binary(i));
        short i3 = (short) (i1 << 8 | i2);
        System.out.println(byte2binary(i2));
        System.out.println(short2binary(i3));
    }
}
