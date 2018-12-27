package net.udp.search;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;

/**
 * @Author lw
 * @Date 2018-12-26 17:58:29
 **/
public class UDPProvider {

    public static void main(String[] args) throws Exception {
        String sn = UUID.randomUUID().toString();
        Provider provider = new Provider(sn);
        provider.start();

        System.in.read();
        provider.exit();
    }

    private static class Provider extends Thread {

        private final String sn;
        private boolean done;
        private DatagramSocket ds;

        public Provider(String sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            try {

                // 作为接收者 指定端口
                ds = new DatagramSocket(6666);
                // 构建接收实体
                final byte[] bytes = new byte[1024];

                while (!done) {
                    DatagramPacket receivePacket = new DatagramPacket(bytes, bytes.length);

                    System.out.println("UDPProvider start...");

                    // 接收
                    ds.receive(receivePacket);

                    String data = new String(receivePacket.getData(), receivePacket.getLength());
                    int responsePort = MessageCreator.parsePort(data);
                    String responseMsg = MessageCreator.buildWithSN(sn);
                    if (responsePort != -1) {
                        // 接收者信息
                        DatagramPacket responsePacket = new DatagramPacket(responseMsg.getBytes(),
                                                                            responseMsg.length(),
                                                                            receivePacket.getAddress(),
                                                                            responsePort);
                        ds.send(responsePacket);
                    }
                }
            } catch (Exception e) {

            } finally {
                close();
                System.out.println("UDPProvider finished");
            }
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        void exit() {
            done = true;
            close();
        }
    }
}
