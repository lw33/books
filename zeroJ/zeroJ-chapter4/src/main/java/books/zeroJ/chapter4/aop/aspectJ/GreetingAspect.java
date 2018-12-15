package books.zeroJ.chapter4.aop.aspectJ;

import books.zeroJ.chapter4.aop.Apology;
import books.zeroJ.chapter4.aop.ApologyImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Author lw
 * @Date 2018-12-15 18:22:48
 **/
//@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "books.zeroJ.chapter4.aop.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;

    //@Around("execution(* books.zeroJ.chapter4.aop.GreetingImpl.*(..))")
    @Around("@annotation(books.zeroJ.chapter4.aop.aspectJ.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }




    public void before() {
        System.out.println("GreetingAspect.before");
    }

    public void after() {
        System.out.println("GreetingAspect.after");
    }
}
