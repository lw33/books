package lw.learning.java8.chapter4;

import lw.learning.java8.entity.Dish;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author lw
 * @Date 2018-12-28 16:25:34
 **/
public class StreamBasic {


    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>(Dish.menu);
        //System.out.println(getLowCaloricDishesNamesInJava7(menu));
        //System.out.println(getLowCaloricDishesNamesInJava8(menu));
        Stream<String> collect = menu.stream().filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3);
        menu.clear();
        //System.out.println(stream.collect(Collectors.toList()));
        System.out.println(collect.collect(Collectors.toList()));
        menu.forEach(System.out::println);
        Iterator<Dish> iterator = menu.iterator();
        iterator.forEachRemaining((s) -> System.out.println(s));
        System.out.println("=================================");
        iterator.forEachRemaining(s -> System.out.println(s));
    }

    @Test
    public void test1() {
        List<Dish> menu = Dish.menu;
        Stream<String> stringStream = menu.stream().filter(d -> {
            System.out.println(d);
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println(d);
            return d.getName();
        }).limit(3);
        System.out.println("end");
        System.out.println(stringStream.collect(Collectors.toList()));

    }

    @Test
    public void test2() {
        List<Dish> collect = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        List<String> lowCaloricDishesNames = new ArrayList<>();

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        for (Dish lowCaloricDish : lowCaloricDishes) {
            lowCaloricDishesNames.add(lowCaloricDish.getName());
        }
        return lowCaloricDishesNames;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream().filter((dish) -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
