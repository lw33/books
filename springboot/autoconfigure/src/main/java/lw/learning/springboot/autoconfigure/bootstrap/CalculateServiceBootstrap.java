package lw.learning.springboot.autoconfigure.bootstrap;

import lw.learning.springboot.autoconfigure.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author lw
 * @Date 2019-02-16 10:46:56
 **/
@SpringBootApplication(scanBasePackages = "lw.learning.springboot.autoconfigure.service")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);
        CalculateService bean = ctx.getBean(CalculateService.class);
        System.out.println(bean.sum(1, 2, 3, 4, 5));

        ctx.close();
    }
}
