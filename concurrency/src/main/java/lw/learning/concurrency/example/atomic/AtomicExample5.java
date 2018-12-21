package lw.learning.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author lw
 * @Date 2018-12-21 19:23:18
 **/
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    public volatile int count = 10;

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if (updater.compareAndSet(atomicExample5, 10, 100)) {
            System.out.println(atomicExample5.count);
        }
        updater.compareAndSet(atomicExample5, 100, 10);
        System.out.println(atomicExample5.count);
    }
}
