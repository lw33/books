package lw.learning.java8.chapter2;

import lw.learning.java8.entity.Apple;

/**
 * @Author lw
 * @Date 2018-12-27 18:52:33
 **/
public class AppleHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
