package lw.learning.springboot.autoconfigure.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author lw
 * @Date 2019-02-16 11:04:26
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyConditional.class)
public @interface ConditionalOnSystemProperty {

    String name();

    String value();
}
