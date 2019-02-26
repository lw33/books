package lw.learning.springboot.exconfiguration.bootstrap;

import lw.learning.springboot.exconfiguration.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lw
 * @Date 2019-02-20 18:51:08
 **/
public class XmlPlaceholderBootstrap {

    public static void main(String[] args) {
        String[] locations = {"classpath:META-INF/spring/spring-context.xml", "classpath:META-INF/spring/user-context.xml"};
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(locations);
        User user = ac.getBean(User.class);
        System.out.println(user);
        ac.close();
    }
}
