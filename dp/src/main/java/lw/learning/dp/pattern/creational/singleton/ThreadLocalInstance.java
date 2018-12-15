package lw.learning.dp.pattern.creational.singleton;

/**
 * @Author lw
 * @Date 2018-12-15 20:46:10
 **/
public class ThreadLocalInstance {

    public static final ThreadLocal<ThreadLocalInstance> threadLocalInstance
            = ThreadLocal.withInitial(ThreadLocalInstance::new);

    private ThreadLocalInstance() {

    }

    public static ThreadLocalInstance getInstance() {
        return threadLocalInstance.get();
    }

}
