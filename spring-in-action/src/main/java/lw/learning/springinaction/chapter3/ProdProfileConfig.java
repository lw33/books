package lw.learning.springinaction.chapter3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author lw
 * @Date 2019-01-15 22:09:19
 **/
@Profile("prod")
@Configuration
public class ProdProfileConfig {

    @Bean
    public String ds() {
        return "prod";
    }
}
