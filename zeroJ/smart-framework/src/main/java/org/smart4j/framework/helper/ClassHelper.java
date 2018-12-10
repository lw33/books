package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author lw
 * @Date 2018-12-10 18:42:57
 **/
public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> set = new HashSet<>();
        for (Class<?> aClass : CLASS_SET) {
            if (aClass.isAnnotationPresent(Service.class)) {
                set.add(aClass);
            }
        }
        return set;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> set = new HashSet<>();
        for (Class<?> aClass : CLASS_SET) {
            if (aClass.isAnnotationPresent(Controller.class)) {
                set.add(aClass);
            }
        }
        return set;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClasses = new HashSet<>();
        beanClasses.addAll(getServiceClassSet());
        beanClasses.addAll(getControllerClassSet());
        return beanClasses;
    }
}
