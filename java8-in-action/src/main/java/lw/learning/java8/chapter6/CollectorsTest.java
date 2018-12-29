package lw.learning.java8.chapter6;

import lw.learning.java8.entity.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lw
 * @Date 2018-12-29 19:46:10
 **/
public class CollectorsTest {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(new ToListCollector<>()));

        System.out.println("\n=========================================================\n");

        System.out.println(menu.stream()
                .collect(Collectors.toList()));

        System.out.println("\n=========================================================\n");

        ArrayList<Dish> collect = menu.stream()
                .collect(ArrayList::new, List::add, List::addAll);
        System.out.println(collect);

        System.out.println("\n=========================================================\n");

    }
}
