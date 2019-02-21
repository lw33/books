package lw.learning.springboot.springapplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author lw
 * @Date 2019-02-16 18:19:32
 **/
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.addApplicationListener(event -> {
            System.out.println("\n=========================================================\n");
            System.out.println("事件" + event);
            System.out.println("\n=========================================================\n");
        });

        context.refresh();

        context.publishEvent("event1");
        context.publishEvent("event2");

        context.close();
    }
}
