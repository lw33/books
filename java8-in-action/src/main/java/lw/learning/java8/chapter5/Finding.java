package lw.learning.java8.chapter5;

import lw.learning.java8.entity.Dish;

import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-28 21:07:31
 **/
public class Finding {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        System.out.println("\n=========================================================\n");

        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!");
        }

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream().noneMatch(d -> d.getCalories() >= 100));

        System.out.println("\n=========================================================\n");

        // 并行情况下限制少
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("\n=========================================================\n");

        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n=========================================================\n");
    }
}
