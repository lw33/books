package lw.learning.concurrency.example.syncContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * @Author lw
 * @Date 2018-12-22 14:20:30
 **/
public class VectorExample {

    private static int clientTotal = 5000;
    private static int threadTotal = 200;
    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {

       /* Vector<Integer> vector = new Vector<>();
        Iterator<Integer> iterator = vector.iterator();
        vector.add(1);
        vector.add(1);
        //iterator.next();
        //iterator.remove();*/

        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
        list.add(1);
        list.add(1);
        iterator.next();
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
        System.out.println(list.size());
    }

    private static void update() {
        list.add(1);
    }


}
