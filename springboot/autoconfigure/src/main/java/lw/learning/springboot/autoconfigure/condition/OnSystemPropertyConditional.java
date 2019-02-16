package lw.learning.springboot.autoconfigure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author lw
 * @Date 2019-02-16 11:06:23
 **/
public class OnSystemPropertyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = String.valueOf(map.get("name"));
        String value = String.valueOf(map.get("value"));

        return value.equals(System.getProperty(name));
    }
}
