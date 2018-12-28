package lw.learning.java8.chapter3;

import lw.learning.java8.entity.Apple;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author lw
 * @Date 2018-12-28 15:09:15
 **/
public class Recombination {

    public static void main(String[] args) {
        Predicate<Apple> redApple = (a) -> "red".equals(a.getColor());
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redAndHeavyOrGreen = redApple.and((a -> a.getWeight() > 150))
                .or(a -> "green".equals(a.getColor()));
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        System.out.println(h.apply(1));
        Function<Integer, Integer> compose = f.compose(g);
        System.out.println(compose.apply(1));

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        Function<String, String> transformationPipeline2 = addHeader.andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("java"));
        System.out.println(transformationPipeline2.apply("javac"));

    }


}
