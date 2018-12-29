package lw.learning.java8.chapter6;

import lw.learning.java8.entity.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lw
 * @Date 2018-12-29 17:00:50
 **/
public class Reducing {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .map(Dish::getCalories)
                .collect(Collectors.toList()));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream().collect(Collectors.counting()));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories)));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories)));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", ")));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j)));

        System.out.println("\n=========================================================\n");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);


        System.out.println(numbers.stream()
                .reduce(new ArrayList<Integer>(),
                        (l, e) -> {
                            l.add(e);
                            return l;
                        },
                        (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        }
                ));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum)));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .map(Dish::getName)
                .collect(Collectors.reducing((s1, s2) -> s1 + s2))
                .get());

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + s2)));




    }


}
