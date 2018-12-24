package lw.learning.concurrency.example.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lw
 * @Date 2018-12-23 15:07:25
 **/
@Slf4j
public class DeadLock {

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            synchronized (o1) {
                try {
                    log.info(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    log.info("now");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    log.info("lock");
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized (o2) {
                try {
                    log.info(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    log.info("now");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    log.info("lock");
                }
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
