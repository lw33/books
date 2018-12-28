package lw.learning.java8.chapter5;

import lw.learning.java8.entity.Dish;

import java.util.List;
import java.util.OptionalInt;

/**
 * @Author lw
 * @Date 2018-12-28 23:13:53
 **/
public class BasicTypeStream {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .mapToInt(Dish::getCalories)
                .sum());

        System.out.println("\n=========================================================\n");

        OptionalInt max = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(max);

        System.out.println("\n=========================================================\n");
    }
}
