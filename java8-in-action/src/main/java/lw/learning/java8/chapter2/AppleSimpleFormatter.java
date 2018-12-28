package lw.learning.java8.chapter2;

import lw.learning.java8.entity.Apple;

/**
 * @Author lw
 * @Date 2018-12-27 19:08:32
 **/
public class AppleSimpleFormatter implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g with " + apple.getColor() ;
    }
}
