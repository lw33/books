import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author lw
 * @Date 2019-01-05 21:01:15
 **/
public class IPCapture {


    public static void main(String[] args) {

        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        JpcapCaptor[] jpcapCaptors = new JpcapCaptor[devices.length];
        int caplen = 1512;
        boolean promiscCheck = true;
        for (int i = 0; i < devices.length; i++) {
            try {
                jpcapCaptors[i] = JpcapCaptor.openDevice(devices[i], caplen, promiscCheck, 50);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        URL resource = IPCapture.class.getResource(".");
        String file = resource.getFile();
        String logfile = args == null || args.length == 0 ? "logfile" : args[0];
        logfile = file + logfile;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(logfile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                for (int j = 0; j < jpcapCaptors.length; j++) {
                    Packet packet = jpcapCaptors[j].getPacket();
                    if (packet instanceof IPPacket && ((IPPacket) packet).version == 4) {
                        IPPacket ipPacket = (IPPacket) packet;// 强转
                        String protocol = "";
                        switch ((int) ipPacket.protocol) {
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
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
                        String now = dateTimeFormatter.format(LocalDateTime.now());
                        System.out.println(now + " =========================================================");
                        String check_sum = short2binary((short) (ipPacket.header[10] << 8 | ipPacket.header[11]));
                        IP ip = new IP(ipPacket.version, ipPacket.priority, ipPacket.t_flag, ipPacket.r_flag,
                                ipPacket.length, ipPacket.ident, ipPacket.dont_frag, ipPacket.more_frag,
                                ipPacket.offset, ipPacket.hop_limit, protocol, check_sum,
                                ipPacket.src_ip.getHostAddress(), ipPacket.dst_ip.getHostAddress());
                        String stat = ip.toString();
                        System.out.println(stat);
                        System.out.println();
                        fileWriter.write(now + " =========================================================\n");
                        fileWriter.write(stat);
                        fileWriter.write("\n\n");
                        fileWriter.flush();
                    }
                }
            } catch (Exception e) {

            }
        }
    }


    public static String short2binary(short num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.insert(0, num & 1);
            num >>>= 1;
        }
        return sb.toString();
    }
}
