package lw.learning.springinaction.chapter3;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author lw
 * @Date 2019-01-15 22:10:10
 **/
@Configuration
@Import({DevProfileConfig.class, ProdProfileConfig.class, CF2.class, CF1.class})
public class DSConfig {
}
