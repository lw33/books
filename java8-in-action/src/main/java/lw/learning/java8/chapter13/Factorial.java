package lw.learning.java8.chapter13;

import java.util.stream.LongStream;

/**
 * @Author lw
 * @Date 2018-12-31 17:52:15
 **/
public class Factorial {

    public static int factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i < n; i++) {
            r *= i;
        }
        return r;
    }

    public static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    public static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }


}
