package lw.learning.dp.pattern.creational.singleton;

/**
 * @Author lw
 * @Date 2018-12-13 22:58:18
 **/
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
