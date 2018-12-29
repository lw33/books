package lw.learning.java8.chapter7;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @Author lw
 * @Date 2018-12-29 21:09:11
 **/
public class ParallelStreams {


    @Test
    public void test1() {
        System.out.println(LongStream.iterate(1L, i -> i + 1).limit(100).sum());
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .sum();
                //.reduce(0l, Long::sum);
    }

    public static long iterateSum(long n) {
        return LongStream.iterate(1l, i -> i + 1).limit(n).parallel().sum();
    }

    public static long sequentialSum(long num) {
        long sum = 0;
        for (long i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
    public static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    @Test
    public void test2() {

        Benchmark.measureSumPerf(ParallelStreams::sideEffectParallelSum, 1_000_000);
        Benchmark.measureSumPerf(ParallelStreams::sideEffectSum, 1_000_000);

    }
}
