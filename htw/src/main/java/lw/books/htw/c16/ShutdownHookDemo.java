package lw.books.htw.c16;

import java.io.IOException;

/**
 * @Author lw
 * @Date 2018-12-05 17:58:29
 **/
public class ShutdownHookDemo {

    public void start() {
        System.out.println("ShutdownHookDemo.start");
        ShutdownHook shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    public static void main(String[] args) throws IOException {
        ShutdownHookDemo demo = new ShutdownHookDemo();
        demo.start();
        System.in.read();
        System.out.println("end...");
    }

    class ShutdownHook extends Thread {

        @Override
        public void run() {
            System.out.println("ShutdownHook.run");
        }
    }

}
