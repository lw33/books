package lw.learning.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author lw
 * @Date 2018-12-22 21:34:28
 **/
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something...");
            Thread.sleep(5000);
            return "done";
        });
        new Thread(futureTask).start();
        log.info(futureTask.get());
    }
}
