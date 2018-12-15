package books.zeroJ.chapter4.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-15 14:02:01
 **/
public class CGLibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    public void before() {
        System.out.println("CGLibProxy.before");
    }

    public void after() {
        System.out.println("CGLibProxy.after");
    }
}
