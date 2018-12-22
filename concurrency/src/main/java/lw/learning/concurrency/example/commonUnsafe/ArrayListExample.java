package lw.learning.concurrency.example.commonUnsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * @Author lw
 * @Date 2018-12-22 14:20:30
 **/
public class ArrayListExample {

    private static int threadTotal = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadTotal; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire()) {
                        update(finalI);
                        semaphore.release();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void update(int i) {
        System.out.println(Thread.currentThread().getName() + " " + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
