package net.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author lw
 * @Date 2019-01-04 21:30:47
 **/
public class CloseUtils {
    public static void close(Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
