package lw.learning.java8.chapter9;

/**
 * @Author lw
 * @Date 2018-12-30 16:46:18
 **/
public class Test {
    class E implements A, D {
        @Override
        public void hello() {
            A.super.hello();
        }
    }
}
