package lw.learning.java8.chapter8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lw
 * @Date 2018-12-30 15:51:12
 **/
public class Debug {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

        List<Integer> collect = numbers.stream()
                .peek(x -> System.out.println("From stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
