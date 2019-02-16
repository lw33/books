package lw.learning.springboot.autoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author lw
 * @Date 2019-02-16 10:14:59
 **/
@EnableAutoConfiguration
public class HelloWorldAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(HelloWorldAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String helloWorld = ctx.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        ctx.close();
    }
}
