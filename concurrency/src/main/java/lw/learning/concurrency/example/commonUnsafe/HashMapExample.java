package lw.learning.concurrency.example.commonUnsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * @Author lw
 * @Date 2018-12-22 14:20:30
 **/
public class HashMapExample {

    private static int clientTotal = 5000;
    private static int threadTotal = 200;
    private static Map<HashMapExample, Object> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    String name = Thread.currentThread().getName();
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(map.size());
    }

    private static void update() {
        map.put(new HashMapExample(), null);
    }

}
