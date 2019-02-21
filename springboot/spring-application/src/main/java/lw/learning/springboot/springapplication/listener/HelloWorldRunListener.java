package lw.learning.springboot.springapplication.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author lw
 * @Date 2019-02-16 19:06:00
 **/
public class HelloWorldRunListener implements SpringApplicationRunListener {
    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }
    @Override
    public void starting() {
        System.out.println("\n=========================================================\n");
        System.out.println("HelloWorldRunListener.starting");
        System.out.println("\n=========================================================\n");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
