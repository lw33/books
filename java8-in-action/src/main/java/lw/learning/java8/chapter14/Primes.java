package lw.learning.java8.chapter14;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2018-12-31 20:49:10
 **/
public class Primes {
    public static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    public static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    public static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    public static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        // exception
        return IntStream.concat(IntStream.of(head), primes(tail(numbers).filter(n -> n % head != 0)));
    }

    public static void main(String[] args) {
        IntStream numbers = numbers();
        primes(numbers);
    }
}
