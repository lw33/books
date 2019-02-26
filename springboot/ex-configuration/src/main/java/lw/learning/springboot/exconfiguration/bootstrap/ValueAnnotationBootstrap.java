package lw.learning.springboot.exconfiguration.bootstrap;

import lw.learning.springboot.exconfiguration.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.Locale;

/**
 * @Author lw
 * @Date 2019-02-21 10:47:42
 **/
@EnableAutoConfiguration
public class ValueAnnotationBootstrap {

    @Bean
    public User user1(@Value("${user.id}") Long id) {
        return new User(id);
    }

    @Bean
    public User user2(Environment environment) {
        ConfigurableEnvironment environment1 = (ConfigurableEnvironment) environment;
        for (PropertySource<?> propertySource : environment1.getPropertySources()) {
            System.out.println("\n=========================================================\n");
            System.out.println(propertySource.getName() + ": " + propertySource);
        }
        return new User(Long.parseLong(environment.getProperty("user.id")));
    }

    @Bean
    //@ConfigurationProperties(prefix = "user")
    public User user3() {
        return new User();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        ConfigurableApplicationContext context = builder.web(WebApplicationType.NONE)
                .sources(ValueAnnotationBootstrap.class)
                .run(args);
        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user3", User.class);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
