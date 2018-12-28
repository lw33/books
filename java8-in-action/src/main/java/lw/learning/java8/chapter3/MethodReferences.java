package lw.learning.java8.chapter3;

import lw.learning.java8.entity.Apple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author lw
 * @Date 2018-12-28 14:35:19
 **/
public class MethodReferences {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        inventory.sort(Comparator.comparing(Apple::getWeight));

        List<String> strings = Arrays.asList("a", "b", "c", "A");
        strings.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        strings.sort(String::compareToIgnoreCase);

        Supplier<Apple> appleSupplier1 = () -> new Apple();
        Supplier<Apple> appleSupplier = Apple::new;

        BiFunction<Integer, String, Apple> biFunction1 = (i, s) -> new Apple(i, s);
        BiFunction<Integer, String, Apple> biFunction = Apple::new;

        Map<String, Function<Integer, Object>> map = new HashMap<>();
        map.put("int", Integer::new);
        map.put("double", Double::new);
        map.put("long", Long::new);

        Comparator<Apple> a = (a1, b) -> a1.getWeight().compareTo(b.getWeight());
        Comparator<Apple> b = Comparator.comparing(apple -> apple.getWeight());
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
    }
}
