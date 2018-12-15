package books.zeroJ.chapter4.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-15 15:18:51
 **/
public class CGLibDynamicProxy implements MethodInterceptor {
    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

    public static CGLibDynamicProxy getInstance() {
        return instance;
    }

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
        System.out.println("CGLibDynamicProxy.before");
    }

    public void after() {
        System.out.println("CGLibDynamicProxy.after");
    }
}
