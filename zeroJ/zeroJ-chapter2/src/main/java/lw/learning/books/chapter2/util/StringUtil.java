package lw.learning.books.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * @Author lw
 * @Date 2018-12-07 18:18:20
 **/
public class StringUtil {

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
