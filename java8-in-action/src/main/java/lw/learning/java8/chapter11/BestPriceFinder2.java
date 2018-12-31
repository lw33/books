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
 * @Date 2018-12-31 14:19:22
 **/
public class BestPriceFinder2 {

    public static final List<Shop2> shops = Arrays.asList(new Shop2("BestPrice"),
            new Shop2("LetsSaveBig"),
            new Shop2("MyFavoriteShop"),
            new Shop2("BuyItAll"),
            new Shop2("ShopEasy"));

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });


    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop2 -> shop2.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPricesFuture(String product) {

        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop2 -> CompletableFuture.supplyAsync(() -> shop2.getPrice(product), EXECUTOR))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), EXECUTOR)))
                .collect(Collectors.toList());

        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        test(BestPriceFinder2::findPrices, "javac");
        test(BestPriceFinder2::findPricesFuture, "javac");
    }
}
