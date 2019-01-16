package lw.learning.springinaction.chapter3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lw
 * @Date 2019-01-16 09:15:31
 **/
@Configuration
public class CF2 {

    @Bean
    public String java() {
        return "Java";
    }
}
