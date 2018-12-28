package lw.learning.java8.chapter2;

import lw.learning.java8.entity.Apple;

/**
 * @Author lw
 * @Date 2018-12-27 18:51:26
 **/
public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {

        return "green".equals(apple.getColor());
    }

}
