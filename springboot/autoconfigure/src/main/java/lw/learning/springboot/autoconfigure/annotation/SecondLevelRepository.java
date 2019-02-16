package lw.learning.springboot.autoconfigure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author lw
 * @Date 2019-02-15 21:32:43
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
