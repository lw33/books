package lw.learning.java8.chapter5;

import lw.learning.java8.entity.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lw
 * @Date 2018-12-28 19:58:12
 **/
public class Filtering {

    public static void main(String[] args) {
        List<Dish> collect = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 2, 54);
        list.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        list.stream()
                .limit(3).forEach(System.out::println);

        System.out.println("\n=========================================================\n");
        Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(5)
                .forEach(System.out::println);
        System.out.println("\n=========================================================\n");
        Dish.menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2).forEach(System.out::println);
        System.out.println("\n=========================================================\n");

    }

    @Test
    public void test() {
        System.out.printf("111");
        System.out.println("\n=========================================================\n");
        System.out.printf("111");
    }

}
