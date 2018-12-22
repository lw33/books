package lw.learning.concurrency.example.commonUnsafe;

import java.util.concurrent.*;

/**
 * @Author lw
 * @Date 2018-12-22 13:12:31
 **/
public class StringExample1 {

    private static StringBuilder sb = new StringBuilder();
    private static ConcurrentHashMap<String, Integer> threadMap = new ConcurrentHashMap<>();

    private static int clientTotal = 5000;
    private static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    String name = Thread.currentThread().getName();
                    if (threadMap.contains(name)) {
                        threadMap.put(name, threadMap.get(name) + 1);
                    } else {
                        threadMap.put(name, 1);
                    }
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(sb.length());
        System.out.println(threadMap.size());
    }

    public static void update() {
        sb.append(1);
    }
}
