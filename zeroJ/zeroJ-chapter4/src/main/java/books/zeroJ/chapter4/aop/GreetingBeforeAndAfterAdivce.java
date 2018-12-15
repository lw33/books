package books.zeroJ.chapter4.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-15 15:34:48
 **/
public class GreetingBeforeAndAfterAdivce implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GreetingBeforeAndAfterAdivce.afterReturning");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GreetingBeforeAndAfterAdivce.before");
    }
}
