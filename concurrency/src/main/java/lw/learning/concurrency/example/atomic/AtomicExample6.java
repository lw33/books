package lw.learning.concurrency.example.atomic;

import lombok.extern.slf4j.Slf4j;
import lw.learning.concurrency.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author lw
 * @Date 2018-12-21 19:29:40
 **/
@Slf4j
@ThreadSafe
public class AtomicExample6 {
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        int clientTotal = 5000;
        int threadTotal = 200;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(atomicBoolean);
    }

    private static void test() {
        if (atomicBoolean.compareAndSet(false, true)) {
            System.out.println(Thread.currentThread().getName() + ": success");
            return;
        }
        System.out.print(Thread.currentThread().getName() + ": loop ");
    }
}
