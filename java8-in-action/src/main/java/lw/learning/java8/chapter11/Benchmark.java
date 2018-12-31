package lw.learning.java8.chapter11;

import java.util.List;
import java.util.function.Function;

/**
 * @Author lw
 * @Date 2018-12-31 14:18:24
 **/
public class Benchmark {
    public static void test(Function<String, List<String>> f, String product) {
        long start = System.nanoTime();
        System.out.println(f.apply(product));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }
}
