package lw.learning.java8.chapter14;


import java.util.function.Function;

/**
 * @Author lw
 * @Date 2018-12-31 21:44:01
 **/
public class Combinator {

    public static <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f) {
        return x -> g.apply(f.apply(x));
    }

    public static <A> Function<A, A> repeat(int n, Function<A, A> f) {
        return n == 0 ? x -> x : compose(f, repeat(n - 1, f));
    }

    public static void main(String[] args) {
        System.out.println(repeat(3, (Integer x) -> x*2).apply(10));
    }
}
