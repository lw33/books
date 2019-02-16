package lw.learning.springboot.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;

/**
 * @Author lw
 * @Date 2019-02-16 09:58:13
 **/
//@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "Hello World";
    }
}
