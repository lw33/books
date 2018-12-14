package lw.learning.dp.pattern.creational.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author lw
 * @Date 2018-12-13 23:00:05
 **/
public class LazyTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " " + instance);
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }

    @Test
    public void test() throws Exception {
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingleton lazySingleton = declaredConstructor.newInstance();
        System.out.println(lazySingleton == LazySingleton.getInstance());
    }
    
    @Test
    public void test1() throws Exception {
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor();
        Field flag = LazySingleton.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.setBoolean(LazySingleton.getInstance(), true);
        declaredConstructor.setAccessible(true);
        LazySingleton lazySingleton = declaredConstructor.newInstance();
        System.out.println(lazySingleton == LazySingleton.getInstance());
    }
}
