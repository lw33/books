package books.zeroJ.chapter4.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author lw
 * @Date 2018-12-15 15:16:02
 **/
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object res = method.invoke(target, args);
        after();
        return res;
    }

    public void before() {
        System.out.println("JDKDynamicProxy.before");
    }

    public void after() {
        System.out.println("JDKDynamicProxy.after");
    }
}
