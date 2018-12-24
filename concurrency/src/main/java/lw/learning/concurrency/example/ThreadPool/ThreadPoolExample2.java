package lw.learning.concurrency.example.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author lw
 * @Date 2018-12-22 23:35:11
 **/
@Slf4j
public class ThreadPoolExample2 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        //scheduledExecutorService.schedule(() -> System.out.println("java"), 1, TimeUnit.SECONDS);
        //System.out.println();
        //scheduledExecutorService.scheduleAtFixedRate(() -> log.info("java"), 0, 3, TimeUnit.SECONDS);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("java");
            }
        }, new Date(), 3*1000);

    }
}
