package lw.learning.concurrency.example.aqs;

import java.util.concurrent.*;

/**
 * @Author lw
 * @Date 2018-12-22 21:29:29
 **/
public class FutureExample1 {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("do something...");
            Thread.sleep(5000);
            return "done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> submit = executorService.submit(new MyCallable());
        System.out.println(submit.get());
    }
}
