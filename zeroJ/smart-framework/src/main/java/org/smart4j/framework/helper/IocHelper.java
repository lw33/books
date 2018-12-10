package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-10 21:26:22
 **/
public class IocHelper {

    static {
        // 获取被管理的bean
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        // 遍历
        beanMap.forEach((cls, obj) -> {
            Field[] fields = cls.getDeclaredFields();
            // 遍历对象所有的成员变量
            for (Field field : fields) {
                //如果成员变量上有 Inject 注解
                if (field.isAnnotationPresent(Inject.class)) {
                    // 判断被管理的对象中是否有成员所需的类型的变量
                    if (beanMap.containsKey(field.getType())) {
                        // 通过反射设置成员的值
                        ReflectionUtil.setField(obj, field,beanMap.get(field.getType()));
                    }
                }
            }
        });
    }
}
