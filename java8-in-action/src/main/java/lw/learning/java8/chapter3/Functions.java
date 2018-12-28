package lw.learning.java8.chapter3;

import lw.learning.java8.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-27 23:11:27
 **/
public class Functions {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("java", "javac", "javap", "python");
        List<String> java = filter(strings, (s) -> s.startsWith("java"));
        System.out.println(java);
        forEach(strings, s -> System.out.println(s + " " + "lf"));
        List<String> map = map(strings, (s1) -> s1 + "===>lf");
        System.out.println(map);

        IntPredicate intPredicate = i -> i % 2 == 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(intPredicate.test(i));
        }

        int i = 1337;
        int finalI = i;
        Runnable runnable = () -> System.out.println(finalI);
        i = 100;
        map(strings, Apple::new);

    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                res.add(t);
            }
        }
        return res;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> res = new ArrayList<>();
        for (T t : list) {
            res.add(f.apply(t));
        }
        return res;
    }

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    @FunctionalInterface
    interface IntPredicate {
        boolean test(int t);
    }


    @FunctionalInterface
    interface Consumer<T> {
        void accept(T t);
    }

    @FunctionalInterface
    interface Function<T, R>{
        R apply(T t);
    }
}
