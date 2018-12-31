package lw.learning.java8.chapter11;

import java.util.Random;

/**
 * @Author lw
 * @Date 2018-12-30 21:36:17
 **/
public class Shop2 {


    private String name;

    private static final Random random = new Random();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop2(String name) {
        this.name = name;
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public Shop2() {
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


}
