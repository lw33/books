package zeroD.chapter4.provider;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author lw
 * @Date 2019-01-06 13:48:42
 **/
public class Provider {

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("rmi.xml");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
