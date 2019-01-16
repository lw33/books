package lw.learning.springinaction.chapter3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author lw
 * @Date 2019-01-15 22:08:05
 **/
@Profile("dev")
@Configuration
public class DevProfileConfig {

    @Bean
    public String ds() {
        return "dev";
    }
}
