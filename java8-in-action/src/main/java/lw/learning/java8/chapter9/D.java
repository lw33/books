package lw.learning.java8.chapter9;

/**
 * @Author lw
 * @Date 2018-12-30 16:45:56
 **/
public interface D {
    default void hello() {
        System.out.println("D.hello");
    }
}
