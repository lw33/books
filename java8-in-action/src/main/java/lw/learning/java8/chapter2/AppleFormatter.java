package lw.learning.java8.chapter2;

import lw.learning.java8.entity.Apple;

/**
 * @Author lw
 * @Date 2018-12-27 19:06:14
 **/
@FunctionalInterface
public interface AppleFormatter {

    String accept(Apple apple);
}
