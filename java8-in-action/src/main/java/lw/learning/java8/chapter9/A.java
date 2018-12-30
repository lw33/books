package lw.learning.java8.chapter9;

/**
 * @Author lw
 * @Date 2018-12-30 16:44:21
 **/
public interface A {

    default void hello() {
        System.out.println("A.hello");
    }
}
