package lw.learning.java8.chapter6;

import lw.learning.java8.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * @Author lw
 * @Date 2018-12-29 19:08:09
 **/
public class GroupBy {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.groupingBy(d -> {
                    if (d.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (d.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                })));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(d -> {
                    if (d.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (d.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }))));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting())));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                        Optional::get
                ))));

        System.out.println("\n=========================================================\n");

        Map<Dish.Type, Integer> collect = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(collect);

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toSet()))));

        System.out.println("\n=========================================================\n");

        Map<Boolean, HashSet<String>> vegetableMap = menu.stream()
                .collect(groupingBy(Dish::isVegetarian, mapping(Dish::getName, toCollection(HashSet::new))));
        System.out.println(vegetableMap);

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType, mapping(Dish::getName, toSet())))));

        System.out.println("\n=========================================================\n");

        System.out.println(partitionPrimes(1000000000));

        System.out.println("\n=========================================================\n");

    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(0, n).boxed()
                .collect(partitioningBy(GroupBy::isPrime));
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
