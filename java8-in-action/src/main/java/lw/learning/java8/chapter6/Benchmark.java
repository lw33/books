package lw.learning.java8.chapter6;

import java.util.function.Consumer;

/**
 * @Author lw
 * @Date 2018-12-29 20:10:06
 **/
public class Benchmark {

    public static void main(String[] args) {
        int times = 10;
        int n = 1_000_000;

        test(times, n, PrimeNumbersCollector::partitionPrimesWithCustomCollectorRaw);
        test(times, n, PrimeNumbersCollector::partitionPrimesWithCustomCollector);
        test(times, n, GroupBy::partitionPrimes);

    }

    public static void test(int times,int n, Consumer<Integer> consumer) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < times; i++) {
            long start = System.nanoTime();
            consumer.accept(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            fastest = fastest > duration ? duration : fastest;
        }

        System.out.println("Fastest execution done in " + fastest + " msecs");
    }
}
