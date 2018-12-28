package lw.learning.java8.chapter2;

import lw.learning.java8.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-27 17:58:40
 **/
public class FilteringApples {

    public FilteringApples() {
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        System.out.println(filterApplesByColor(inventory, "green"));

        System.out.println(filterApples(inventory, new AppleGreenColorPredicate()));


        System.out.println();
        System.out.println("=======================================================");

        System.out.println(filterApples(inventory, "", 150, false));

        System.out.println(filterApples(inventory, new AppleHeavyPredicate()));

        System.out.println();
        System.out.println("=======================================================");

        System.out.println(filterApples(inventory, new AppleRedAndHeavyPredicate()));

        System.out.println();
        System.out.println("=======================================================");

        System.out.println(filterApples(inventory, a -> a.getWeight() > 150));

        System.out.println();
        System.out.println("=======================================================");

        prettyPrintApple(inventory, new AppleSimpleFormatter());

        System.out.println();
        System.out.println("=======================================================");

        prettyPrintApple(inventory, new AppleFancyFormatter());

        System.out.println();
        System.out.println("=======================================================");
        System.out.println(AppleFilter.filter(inventory, a -> "red".equals(a.getColor())));

        System.out.println();
        System.out.println("=======================================================");
        System.out.println(inventory);
        inventory.sort((a, b) -> a.getWeight().compareTo(b.getWeight()));
        System.out.println(inventory);
    }

    private static interface Predicate<T> {
        boolean test(T t);
    }


    private static class AppleFilter {

        public static <T> List<T> filter(List<T> list, FilteringApples.Predicate<T> p) {
            List<T> result = new ArrayList<>();
            for (T t : list) {
                if (p.test(t)) {
                    result.add(t);
                }
            }
            return result;
        }
    }


    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            System.out.println(appleFormatter.accept(apple));
        }
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }


    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            try {
                if (p.test(apple)) {
                    result.add(apple);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

  /*  public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }*/
}
