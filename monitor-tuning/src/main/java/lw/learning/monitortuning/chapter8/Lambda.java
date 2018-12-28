package lw.learning.monitortuning.chapter8;

/**
 * @Author lw
 * @Date 2018-12-27 19:51:56
 **/
public class Lambda {


    public static void main(String[] args) {

    }

    public static void f1() {
        Runnable run = () -> {
            System.out.println("a");
        };
    }

    public static void f2() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        };
    }

    public void f3() {
        Runnable run = () -> {
            String s = this.toString();
            System.out.println();
        };
    }

    public void f4() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                String s = this.toString();
                System.out.println();
            }
        };
    }
}
