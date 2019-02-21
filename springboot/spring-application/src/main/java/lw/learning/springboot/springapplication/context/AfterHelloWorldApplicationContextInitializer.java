package lw.learning.springboot.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author lw
 * @Date 2019-02-16 16:39:44
 **/
@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C applicationContext) {

        System.out.println("AfterHelloWorldApplicationContextInitializer.initialize");
        System.out.println("id = " + applicationContext.getId());
    }
}
