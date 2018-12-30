package lw.learning.java8.chapter9;

/**
 * @Author lw
 * @Date 2018-12-30 16:44:41
 **/
public interface B extends A{

    @Override
    default void hello() {
        System.out.println("B.hello");
    }
}
