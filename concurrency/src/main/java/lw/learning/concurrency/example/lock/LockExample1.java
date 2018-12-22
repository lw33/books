package lw.learning.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;
import lw.learning.concurrency.annotation.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lw
 * @Date 2018-12-21 13:55:49
 **/
@Slf4j
@NotThreadSafe
public class LockExample1 {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //executorService.shutdown();
        System.out.println(count);
    }

    public static  void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }


}
