package books.zeroJ.chapter4.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author lw
 * @Date 2018-12-15 15:36:38
 **/
@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object res = invocation.proceed();
        after();
        return res;
    }

    public void before() {
        System.out.println("GreetingAroundAdvice.before");
    }

    public void after() {
        System.out.println("GreetingAroundAdvice.after");
    }
}
