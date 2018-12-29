package lw.learning.java8.chapter7;

import java.util.function.Function;

/**
 * @Author lw
 * @Date 2018-12-29 21:11:30
 **/
public class Benchmark {
    public static void main(String[] args) {
        System.out.println("Sequential sum done in: " + measureSumPerf(ParallelStreams::sequentialSum, 1_000_000_000) + " msecs");

        System.out.println("Iterate sum done in: " + measureSumPerf(ParallelStreams::iterateSum, 1_000_000_00) + " msecs");

        System.out.println("Parallel sum done in: " + measureSumPerf(ParallelStreams::parallelRangedSum, 1_000_000_000) + " msecs");

    }
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            Long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
