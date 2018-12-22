package lw.learning.concurrency.example.commonUnsafe;

import lw.learning.concurrency.annotation.NotThreadSafe;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author lw
 * @Date 2018-12-22 13:53:35
 **/
@NotThreadSafe
public class DateFormatExample3 {

    private static DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("yyyyMMdd");

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
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    public static void update() {
        DateTime.parse("20180101", dateTimeFormat).toDateTime();
    }
}
