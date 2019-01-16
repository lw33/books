package lw.learning.springinaction.chapter2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lw
 * @Date 2019-01-15 20:45:06
 **/
@Configuration
//@ComponentScan
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

}
