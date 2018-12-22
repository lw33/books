package lw.learning.concurrency.example.aqs;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author lw
 * @Date 2018-12-22 18:24:36
 **/
public class CyclicBarrierExample {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread.sleep(1000);
            executorService.submit(() -> {
                try {
                    race(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void race(int i) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        System.out.println("ready " + i);
        try {
            cyclicBarrier.await(new Random().nextInt(10000), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println(cyclicBarrier.getNumberWaiting());
        }
        System.out.println("continue " + i);
    }
}
