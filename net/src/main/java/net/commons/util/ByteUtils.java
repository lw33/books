package net.commons.util;

/**
 * @Author lw
 * @Date 2019-01-03 17:00:53
 **/
public class ByteUtils {

    public static boolean startsWith(byte[] src, byte[] prefix) {
        if (src == null || prefix == null || src.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (src[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }
}
