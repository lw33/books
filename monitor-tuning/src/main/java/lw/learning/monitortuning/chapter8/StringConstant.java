package lw.learning.monitortuning.chapter8;

/**
 * @Author lw
 * @Date 2018-12-25 19:55:55
 **/
public class StringConstant {

    public static void main(String[] args) {


    }

    public static void f1() {
        final String x = "hello";
        final String y = x + " world";
        String z = x + " " +  y;
        System.out.println(z);
    }

    public static void f2() {
        String x = "hello";
        String y = x + " world";
        String z = x + " " +  y;
        System.out.println(z);
    }
}
