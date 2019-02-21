package lw.learning.spring.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @Author lw
 * @Date 2019-02-18 20:38:19
 **/
@RestController
public class HelloAsyncController {

    @GetMapping("/hello")
    public DeferredResult<String> hello() {
        DeferredResult<String> res = new DeferredResult<>();
        res.setResult("hello");
        print("hello into controller");
        res.onCompletion(() -> print("hello onCompletion"));
        return res;
    }

    @GetMapping("/hc")
    public Callable<String> hc() {
        print("hc into controller");
        return () -> {
            print("hc in callable");
            return "hc";
        };
    }
    @GetMapping("/cs")
    public CompletionStage<String> cs() {
        print("cs into controller");
        return CompletableFuture.supplyAsync(() -> {
            print("cs into completion");
            return "cs";
        });
    }

    public static void print(Object object) {
        System.out.println("[" + Thread.currentThread().getName() + "]: " + object);
    }

}
