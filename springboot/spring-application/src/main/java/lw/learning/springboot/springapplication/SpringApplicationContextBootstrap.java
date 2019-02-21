package lw.learning.springboot.springapplication;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author lw
 * @Date 2019-02-16 19:38:26
 **/
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        System.out.println("\n=========================================================\n");
        System.out.println(context.getClass().getName());
        System.out.println("\n=========================================================\n");

        context.close();
    }
}
