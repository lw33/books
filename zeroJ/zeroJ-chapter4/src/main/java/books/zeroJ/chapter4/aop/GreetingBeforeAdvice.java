package books.zeroJ.chapter4.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-15 15:31:19
 **/
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GreetingBeforeAdvice.before");
    }
}
