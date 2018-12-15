package books.zeroJ.chapter4.aop;

import books.zeroJ.chapter4.aop.aspectJ.Tag;
import org.springframework.stereotype.Component;

/**
 * @Author lw
 * @Date 2018-12-15 15:12:56
 **/
@Component
public class GreetingImpl implements Greeting{

    @Override
    public void sayHello(String name) {
        //before();
        System.out.println("GreetingImpl.sayHello " + name);
        //int i = 1 / 0;
        //after();
    }

    @Tag
    public void goodMorning(String name) {
        System.out.println("Good morning " + name);
    }

    public void goodNight(String name) {
        System.out.println("GreetingImpl.goodNight " + name);
    }

   /* public void before() {
        System.out.println("GreetingImpl.before");
    }

    public void after() {
        System.out.println("GreetingImpl.after");
    }*/
}

