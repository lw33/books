package lw.learning.java8.chapter5;

import lw.learning.java8.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author lw
 * @Date 2018-12-28 20:11:31
 **/
public class Mapping {

    public static void main(String[] args) {

        System.out.println("\n=========================================================\n");
        Dish.menu.stream()
                .map(Dish::getName)
                .forEach(System.out::println);
        System.out.println("\n=========================================================\n");

        List<String> strings = Arrays.asList("Java 8", "Lambdas", "In", "Action");

        List<Integer> collect = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("\n=========================================================\n");

        Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .forEach(System.out::println);
        System.out.println("\n=========================================================\n");

        List<String[]> collect1 = strings.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("\n=========================================================\n");

        List<Stream<String>> collect2 = strings.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .collect(Collectors.toList());
        for (Stream<String> stringStream : collect2) {
            stringStream.forEach(System.out::println);
        }

        System.out.println("\n=========================================================\n");

        List<String> collect3 = strings.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect3);

        System.out.println("\n=========================================================\n");

        int[] ints = {1, 2, 3, 4, 5};
        int[] ints1 = Arrays.stream(ints)
                .map(i -> i * i)
                .toArray();
        System.out.println(Arrays.toString(ints1));

        System.out.println("\n=========================================================\n");

        int[] ints2 = {1, 2, 3};
        int[] ints3 = {3, 4};
        Arrays.stream(ints)
                .boxed()
                .flatMap(i -> Arrays.stream(ints3).boxed().map(x -> new int[]{i, x}))
                .forEach(s -> System.out.print(Arrays.toString(s)));

        System.out.println("\n=========================================================\n");

        List<int[]> collect4 = Arrays.stream(ints2)
                .boxed()
                .flatMap(i -> Arrays.stream(ints3).filter(j -> (i + j) % 3 == 0).boxed().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        collect4.stream()
                .forEach(s -> System.out.print(Arrays.toString(s) + "  "));

        System.out.println("\n=========================================================\n");

    }
}
