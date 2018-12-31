package lw.learning.java8.chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static lw.learning.java8.chapter11.Benchmark.test;

/**
 * @Author lw
 * @Date 2018-12-30 22:25:38
 **/
public class BestPriceFinder1 {

    public static final List<Shop1> shops = Arrays.asList(new Shop1("BestPrice"),
            new Shop1("LetsSaveBig"),
            new Shop1("MyFavoriteShop"),
            new Shop1("BuyItAll"),
            new Shop1("ShopEasy"));

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public static List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesParallel(String product) {
        return shops.stream().parallel()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product)))
                .collect(Collectors.toList());
        return completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
    public static List<String> findPricesFutureExecutor(String product) {
        List<CompletableFuture<String>> completableFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), EXECUTOR))
                .collect(Collectors.toList());
        return completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        test(BestPriceFinder1::findPricesSequential, "javac");
        test(BestPriceFinder1::findPricesParallel, "javac");
        test(BestPriceFinder1::findPricesFuture, "javac");
        test(BestPriceFinder1::findPricesFutureExecutor, "javac");
    }


}
