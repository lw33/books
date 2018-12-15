package books.zeroJ.chapter4.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-15 15:31:45
 **/
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GreetingAfterAdvice.afterReturning");
    }
}
