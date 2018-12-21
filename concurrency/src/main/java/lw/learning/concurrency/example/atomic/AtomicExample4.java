package lw.learning.concurrency.example.atomic;

import lw.learning.concurrency.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author lw
 * @Date 2018-12-21 19:18:05
 **/
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 134);
        count.compareAndSet(0, 324);
        System.out.println(count);
    }

}
