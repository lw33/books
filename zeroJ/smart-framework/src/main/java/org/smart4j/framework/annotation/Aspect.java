package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * @Author lw
 * @Date 2018-12-15 19:16:51
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
