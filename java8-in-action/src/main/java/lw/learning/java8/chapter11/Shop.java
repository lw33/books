package lw.learning.java8.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author lw
 * @Date 2018-12-30 21:36:17
 **/
public class Shop {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> doubleCompletableFuture = new CompletableFuture<>();
        new Thread(() -> {
            //try {

                double price = calculatePrice(product);
                doubleCompletableFuture.complete(price);
                //throw new RuntimeException("lf");
            //} catch (Exception e) {
            //    doubleCompletableFuture.completeExceptionally(e);
            //}
        }).start();
        return doubleCompletableFuture;
    }
    public Future<Double> getPriceAsyncBySupplyAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
    public Shop() {
    }

    public void doSomethingElse() {
        delay();
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start = System.nanoTime();
        System.out.println(shop.getPrice("javac"));
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after: " + invocationTime + " msecs");
        shop.doSomethingElse();
        invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Total time: " + invocationTime + " msecs");

        start = System.nanoTime();
        Future<Double> javac1 = shop.getPriceAsync("javac");
        invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after: " + invocationTime + " msecs");
        shop.doSomethingElse();
        try {
            System.out.println(javac1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Total time: " + invocationTime + " msecs");
        start = System.nanoTime();
        Future<Double> javac2 = shop.getPriceAsync("javac");
        invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after: " + invocationTime + " msecs");
        shop.doSomethingElse();
        try {
            System.out.println(javac2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Total time: " + invocationTime + " msecs");
    }
}
