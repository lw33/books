package lw.learning.java8.chapter2;

import lw.learning.java8.entity.Apple;

/**
 * @Author lw
 * @Date 2018-12-27 18:50:15
 **/
@FunctionalInterface
public interface ApplePredicate {

    boolean test(Apple apple) throws Exception;

    default void test() {
        System.out.println();
    }

}
