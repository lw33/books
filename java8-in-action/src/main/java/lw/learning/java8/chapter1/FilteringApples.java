package lw.learning.java8.chapter1;

import lw.learning.java8.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author lw
 * @Date 2018-12-27 17:58:40
 **/
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> apples1 = filterApples(inventory, a -> a.getWeight() > 150);
        System.out.println(apples1);
        List<Apple> apples2 = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(apples2);
        List<Apple> apples3 = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(apples3);

    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
