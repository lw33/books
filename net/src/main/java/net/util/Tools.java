package net.util;

/**
 * @Author lw
 * @Date 2019-01-02 19:57:17
 **/
public class Tools {

    public static void main(String[] args) {
        byte[] bytes = int2byteArray(14);
        System.out.println(byteArray2Int(bytes));
    }

    public static int byteArray2Int(byte[] b) {
        if (b.length != 4) {
            return 0;
        }
        return byteArray2Int(b, 0, 3);
    }

    /**
     * [start, end]
     * @param b
     * @param start
     * @param end
     * @return
     */
    public static int byteArray2Int(byte[] b, int start, int end) {
        if (end - start + 1 != 4) {
            return 0;
        }

        return b[end--] & 0xFF |
                (b[end--] & 0xFF) << 8 |
                (b[end--] & 0xFF) << 16 |
                (b[end] & 0xFF) << 24;
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
