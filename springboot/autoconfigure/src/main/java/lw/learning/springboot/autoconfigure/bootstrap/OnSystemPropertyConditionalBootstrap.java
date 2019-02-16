package lw.learning.springboot.autoconfigure.bootstrap;

import lw.learning.springboot.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author lw
 * @Date 2019-02-16 10:46:56
 **/
public class OnSystemPropertyConditionalBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "lw")
    public String lw() {
        return "Hello lw";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(OnSystemPropertyConditionalBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String lw = ctx.getBean("lw", String.class);
        System.out.println(lw);
        ctx.close();
    }
}
