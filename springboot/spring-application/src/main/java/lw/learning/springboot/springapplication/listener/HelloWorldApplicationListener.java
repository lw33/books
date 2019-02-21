package lw.learning.springboot.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author lw
 * @Date 2019-02-16 16:53:16
 **/
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("\n=========================================================\n");
        System.out.println("HelloWorldApplicationListener.onApplicationEvent");
        System.out.println(event.getApplicationContext().getId());
        System.out.println(event.getTimestamp());
        System.out.println("\n=========================================================\n");
    }
}
