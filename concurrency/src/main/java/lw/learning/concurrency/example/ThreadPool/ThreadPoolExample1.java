package lw.learning.concurrency.example.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2018-12-22 23:35:11
 **/
@Slf4j
public class ThreadPoolExample1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.submit(() -> {
                log.info("task: {}", finalI);
            });
        }
        executorService.shutdown();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.submit(() -> log.info("task: {}", finalI));
        }
    }
}
