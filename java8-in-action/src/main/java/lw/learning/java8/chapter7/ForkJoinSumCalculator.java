package lw.learning.java8.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author lw
 * @Date 2018-12-29 22:21:42
 **/
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000_0000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        int mid = start + (length >> 1);
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, mid);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, mid, end);
        rightTask.fork();
        Long right = rightTask.compute();
        //Long right = rightTask.join();
        Long left = leftTask.join();
        return right + left;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(forkJoinSumCalculator);
    }

    public static void main(String[] args) {
        System.out.println("Fork Join sum done in: " + Benchmark.measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 1_000_000_0) + " msecs");
    }
}
