package books.zeroJ.chapter4.aop;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author lw
 * @Date 2018-12-15 15:14:56
 **/
public class Client {

    private  ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");;

    @Test
    public void test1() {
        Greeting g = new GreetingProxy(new GreetingImpl());
        g.sayHello("java");
    }

    @Test
    public void test2() {
        Greeting g = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        g.sayHello("java");
    }

    @Test
    public void test3() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\lw\\Desktop\\class");
        Greeting g = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        System.out.println(g.getClass());
        g.sayHello("java");
    }

    @Test
    public void test4() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        Greeting proxy = (Greeting) proxyFactory.getProxy();
        proxy.sayHello("java");
    }

    @Test
    public void test5() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdivce());
        Greeting proxy = (Greeting) proxyFactory.getProxy();
        proxy.sayHello("java");
    }

    @Test
    public void test6() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting proxy = (Greeting) proxyFactory.getProxy();
        proxy.sayHello("java");
    }

    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Greeting greetingProxy = context.getBean("greetingProxy", Greeting.class);
        greetingProxy.sayHello("java");
    }

    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Apology greetingProxy = context.getBean("greetingProxy", Apology.class);
        greetingProxy.saySorry("javac");
    }

    @Test
    public void test9() {

        GreetingImpl greetingProxy = context.getBean("greetingProxy", GreetingImpl.class);
        greetingProxy.goodMorning("java");
        greetingProxy.sayHello("python");
    }

    @Test
    public void test10() {
        GreetingImpl bean = context.getBean(GreetingImpl.class);
        bean.sayHello("java");
    }

    @Test
    public void test11() {
        GreetingImpl bean = context.getBean(GreetingImpl.class);
        bean.sayHello("java");
        bean.goodMorning("javac");
    }

    @Test
    public void test12() {
        GreetingImpl bean = context.getBean(GreetingImpl.class);
        bean.sayHello("jva");
        Apology bean1 = (Apology) bean;
        bean1.saySorry("javac");
    }
}
