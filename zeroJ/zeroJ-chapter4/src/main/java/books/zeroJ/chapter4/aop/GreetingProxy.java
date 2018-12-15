package books.zeroJ.chapter4.aop;

/**
 * @Author lw
 * @Date 2018-12-15 15:13:53
 **/
public class GreetingProxy implements Greeting {
    private GreetingImpl greeting;

    public GreetingProxy(GreetingImpl greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    public void before() {
        System.out.println("GreetingProxy.before");
    }

    public void after() {
        System.out.println("GreetingProxy.after");
    }
}
