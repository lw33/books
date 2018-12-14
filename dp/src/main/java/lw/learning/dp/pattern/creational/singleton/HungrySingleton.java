package lw.learning.dp.pattern.creational.singleton;

import java.io.Serializable;

public class HungrySingleton implements Serializable {

    private static final long serialVersionUID = -6718549836721799899L;

    private static HungrySingleton ourInstance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return ourInstance;
    }

    private HungrySingleton() {
        if (ourInstance != null) {
            throw new RuntimeException("单例对象不允许反射调用。。。");
        }
    }

    private Object readResolve() {
        return ourInstance;
    }
}
