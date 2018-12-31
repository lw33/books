package lw.learning.java8.chapter14;

/**
 * @Author lw
 * @Date 2018-12-31 20:56:14
 **/
public interface MyList<T> {
    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }
}
