package lw.learning.springboot.autoconfigure.bootstrap;

import lw.learning.springboot.autoconfigure.repository.MyFRepository;
import lw.learning.springboot.autoconfigure.repository.MySRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author lw
 * @Date 2019-02-15 21:36:22
 **/
@ComponentScan("lw.learning.springboot.autoconfigure.repository")
public class RepositoryBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        MyFRepository myFRepository = context.getBean("myFRepository", MyFRepository.class);
        MySRepository mySRepository = context.getBean("mySRepository", MySRepository.class);
        System.out.println(myFRepository);
        System.out.println(mySRepository);
        context.close();
    }
}
