package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-10 20:45:57
 **/
public class ReflectionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            logger.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object res;
        try {
            method.setAccessible(true);
            res = method.invoke(obj, args);
        } catch (Exception e) {
            logger.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return res;
    }

    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            logger.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }
}
