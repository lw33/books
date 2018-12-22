package lw.learning.concurrency.example.commonUnsafe;

import lw.learning.concurrency.annotation.NotThreadSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author lw
 * @Date 2018-12-22 13:53:35
 **/
@NotThreadSafe
public class DateFormatExample1 {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private static int clientTotal = 5000;
    private static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
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
    }

    public static void update() {
        try {
            dateFormat.parse("20180101");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
