package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author lw
 * @Date 2018-12-13 20:51:45
 **/
public class CodecUtil {

    private static final Logger logger = LoggerFactory.getLogger(CodecUtil.class);

    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("encode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
