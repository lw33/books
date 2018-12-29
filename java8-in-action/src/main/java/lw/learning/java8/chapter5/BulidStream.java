package lw.learning.java8.chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author lw
 * @Date 2018-12-28 23:27:31
 **/
public class BulidStream {

    public static void main(String[] args) {

        System.out.println("\n=========================================================\n");

        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
                                //.mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream.forEach(ints -> System.out.println(Arrays.toString(ints)));

        System.out.println("\n=========================================================\n");

        Stream<String> stringStream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        int[] numbers = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(numbers).sum());

        System.out.println("\n=========================================================\n");

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("README.md"))) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .filter(s -> !"#".equals(s))
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(uniqueWords);

        System.out.println("\n=========================================================\n");

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        Stream.iterate(new int[]{0, 1}, nums -> new int[]{nums[1], nums[0] + nums[1]})
                .limit(10)
                .forEach(nums -> System.out.println("(" + nums[0] + ", " + nums[1] + ")"));

        System.out.println("\n=========================================================\n");

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        IntStream generate = IntStream.generate(() -> 1);

        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        //IntStream.generate(fib).limit(10).forEach(System.out::println);
        IntStream.generate(fib).forEach(System.out::println);

        System.out.println("\n=========================================================\n");
    }
}
