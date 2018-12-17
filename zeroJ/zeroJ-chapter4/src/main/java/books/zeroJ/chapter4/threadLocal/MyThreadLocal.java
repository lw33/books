package books.zeroJ.chapter4.threadLocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author lw
 * @Date 2018-12-17 18:19:49
 **/
public class MyThreadLocal<T> {

    private Map<Thread, T> threadTMap = new ConcurrentHashMap<>();

    public T get() {
        Thread currentThread = Thread.currentThread();
        T value = threadTMap.get(currentThread);
        if (value == null && !threadTMap.containsKey(currentThread)) {
            value = initialValue();
            threadTMap.put(currentThread, value);
        }
        return value;
    }

    public void set(T value) {
        Thread currentThread = Thread.currentThread();
        threadTMap.put(currentThread, value);
    }

    public void remove() {
        threadTMap.remove(Thread.currentThread());
    }

    protected T initialValue() {
        return null;
    }
}
