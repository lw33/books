package lw.learning.springboot.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @Author lw
 * @Date 2019-02-16 16:39:44
 **/
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>, Ordered {
    @Override
    public void initialize(C applicationContext) {

        System.out.println("HelloWorldApplicationContextInitializer.initialize");
        System.out.println("id = " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
