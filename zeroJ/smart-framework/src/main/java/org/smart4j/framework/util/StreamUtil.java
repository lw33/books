package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @Author lw
 * @Date 2018-12-13 20:49:20
 **/
public class StreamUtil {


    private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public static String getString(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            logger.error("get string failure", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void copyStream(InputStream in, OutputStream out) {
        try {
            int length;
            byte[] buffer = new byte[1024 * 4];
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            logger.error("copy stream failure", e);
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                logger.error("close stream failure", e);
            }
        }
    }
}
