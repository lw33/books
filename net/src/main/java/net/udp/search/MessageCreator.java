package net.udp.search;

/**
 * @Author lw
 * @Date 2018-12-26 21:18:14
 **/
public class MessageCreator {

    private static final String SN_HEAD = "got cipher, I'm (SN):";
    private static final String PORT_HEAD = "cipher, call (Port):";

    public static String buildPort(int port) {
        return PORT_HEAD + port;
    }

    public static int parsePort(String data) {

        if (data.startsWith(PORT_HEAD)) {
            return Integer.parseInt(data.substring(PORT_HEAD.length()));
        }
        return -1;
    }

    public static String buildWithSN(String sn) {
        return SN_HEAD + sn;
    }

    public static String parseSN(String data) {

        if (data.startsWith(SN_HEAD)) {
            return data.substring(SN_HEAD.length());
        }
        return null;
    }

}
