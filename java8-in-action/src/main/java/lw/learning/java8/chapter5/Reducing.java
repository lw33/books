package lw.learning.java8.chapter5;

import lw.learning.java8.entity.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-28 21:43:48
 **/
public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,4,5,1,2, 100);

        List<Dish> menu = Dish.menu;

        System.out.println("\n=========================================================\n");

        System.out.println(numbers.stream()
                .reduce(0, (a, b) -> a + b));

        System.out.println(numbers.stream().reduce(0, Integer::sum));

        System.out.println(numbers.stream().reduce(Integer::sum));

        System.out.println("\n=========================================================\n");

        System.out.println(numbers.stream().reduce(Math::max));
        System.out.println(numbers.stream().reduce(Math::min));

        System.out.println("\n=========================================================\n");

        Integer reduce = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println(menu.stream().count());

        System.out.println("\n=========================================================\n");


    }
}
