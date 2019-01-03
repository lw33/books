package net.util;

/**
 * @Author lw
 * @Date 2019-01-02 19:57:17
 **/
public class Tools {
    public static int byteArray2Int(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] int2byteArray(int num) {
        return new byte[]{
                (byte) ((num >> 24) & 0xFF),
                (byte) ((num >> 16) & 0xFF),
                (byte) ((num >> 8) & 0xFF),
                (byte) (num & 0xFF)
        };
    }
}
