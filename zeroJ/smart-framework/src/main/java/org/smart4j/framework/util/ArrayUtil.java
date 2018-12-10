package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author lw
 * @Date 2018-12-10 21:15:11
 **/
public class ArrayUtil {

    public static boolean isNotEmpty(Object[] array) {
        return ArrayUtils.isNotEmpty(array);
    }

    public static boolean isEmpty(Object[] array) {
        return ArrayUtil.isEmpty(array);
    }
}
