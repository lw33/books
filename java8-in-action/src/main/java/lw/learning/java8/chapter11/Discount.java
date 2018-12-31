package lw.learning.java8.chapter11;

/**
 * @Author lw
 * @Date 2018-12-31 14:20:31
 **/
public class Discount {

    public enum Code {
        NONE(0),SILVER(5), GOLD(10),
        PLATINUM(15), DIAMOND(20);
        private final int percentage;
        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getCode());
    }

    public static double apply(double price, Code code) {
        Shop2.delay();
        return price * (100 - code.percentage) / 100;
    }
}
