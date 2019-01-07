package zeroD.chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zeroD.chapter4.model.User;

/**
 * @Author lw
 * @Date 2019-01-06 13:40:13
 **/
public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring1.xml");
        User user = ac.getBean("user", User.class);
        System.out.println(user);
    }

}
