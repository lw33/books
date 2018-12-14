package lw.learning.dp.pattern.creational.singleton;

public class LazyDbCheckSingleton {

    private volatile static LazyDbCheckSingleton lazyDbCheckSingleton;


    private LazyDbCheckSingleton() {

    }

    public static LazyDbCheckSingleton getInstance() {
        if (lazyDbCheckSingleton == null) {
            synchronized (LazyDbCheckSingleton.class) {
                if (lazyDbCheckSingleton == null) {
                    // 1. 分配内存
                    // 2. 初始化对象
                    // 3. 设置引用指向对象   intra-thread semantics
                    lazyDbCheckSingleton = new LazyDbCheckSingleton();
                }
            }
        }
        return lazyDbCheckSingleton;
    }
}
