package zeroD.chapter4.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zeroD.chapter4.service.UserService;

/**
 * @Author lw
 * @Date 2019-01-06 14:35:27
 **/
public class RmiInvokerClient {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ApplicationContext ac = new ClassPathXmlApplicationContext("rmi.xml");
        UserService userService = ac.getBean("userRmiServiceProxy", UserService.class);
        System.out.println(userService.findByName("lw"));
        System.out.println(userService.findByName("java"));
    }
}
