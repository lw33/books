package lw.learning.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2018-12-21 19:42:31
 **/
@Slf4j
public class Sync1 {
    public void test1() {
        System.out.println(Thread.currentThread().getName() + ": javac");
        synchronized (this) {
            for (int i = 0; i < 200; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + ": javac");
        for (int i = 0; i < 200; i++) {
            System.out.print(i + " ");
        }
    }

    public synchronized static void test3() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sync1 sync1 = new Sync1();
        executorService.execute(() -> sync1.test2());
        executorService.execute(() -> sync1.test2());

    }
}
