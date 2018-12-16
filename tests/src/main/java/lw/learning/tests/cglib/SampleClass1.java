package lw.learning.tests.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-16 18:15:02
 **/
public class SampleClass1 {
    public void test(String name) throws Throwable {
        System.out.println("hello world");
    }

    public static void main(String[] args) throws Throwable {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass1.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                result = proxy.invoke(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });
        SampleClass1 sample = (SampleClass1) enhancer.create();
        sample.test("name");

    }
}
