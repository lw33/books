package lw.learning.springinaction.chapter3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lw
 * @Date 2019-01-16 09:15:05
 **/
@Configuration
public class CF1 {

    @Bean
    @Qualifier
    public String java() {
        return "java";
    }
}
