package lw.learning.monitortuning.chapter8;

/**
 * @Author lw
 * @Date 2018-12-25 19:21:50
 **/
public class Add {


    public static final int INT = 100000000;
    public static void main(String[] args) {
        long startTime2 = System.nanoTime();
        for (int i = 0; i < INT; ++i) {

        }
        System.out.println("++i time(ms):" + (System.nanoTime() - startTime2) / 1000);
        System.out.println("++i time(s):" + (System.nanoTime() - startTime2) / 1000 / 1000);


        long startTime1 = System.nanoTime();
        for (int i = 0; i < INT; i++) {

        }
        System.out.println("i++ time(ms):" + (System.nanoTime() - startTime1) / 1000);
        System.out.println("i++ time(s):" + (System.nanoTime() - startTime1) / 1000 / 1000);


    }
    public static void f1() {
        int i = 0;
        int j = i++;
    }

    public static void f2() {
        int i = 0;
        int j = ++i;
    }


}
