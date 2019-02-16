package lw.learning.springboot.autoconfigure.autoconfiguration;

import lw.learning.springboot.autoconfigure.annotation.EnableHelloWorld;
import lw.learning.springboot.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lw
 * @Date 2019-02-16 11:39:34
 **/
@EnableHelloWorld
@Configuration
@ConditionalOnSystemProperty(name = "user.name", value = "lw")
public class HelloWorldAutoConfiguration {
}
