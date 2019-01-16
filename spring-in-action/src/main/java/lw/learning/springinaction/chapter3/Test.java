package lw.learning.springinaction.chapter3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author lw
 * @Date 2019-01-16 09:20:29
 **/
public class Test {

    @org.junit.Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DSConfig.class);

        Object java = ac.getBean("java");
        System.out.println(java);
    }
}
