package lw.learning.java8.chapter14;

import java.util.function.Supplier;

/**
 * @Author lw
 * @Date 2018-12-31 20:58:13
 **/
public class LazyList<T> implements MyList<T> {
    private final T head;
    private final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);
        Integer two = numbers.head();
        Integer three = numbers.tail().head();
        Integer four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);
    }
}
