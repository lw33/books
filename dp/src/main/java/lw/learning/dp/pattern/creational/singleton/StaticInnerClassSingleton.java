package lw.learning.dp.pattern.creational.singleton;

/**
 * @Author lw
 * @Date 2018-12-14 22:29:16
 **/
public class StaticInnerClassSingleton {

    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }
    private StaticInnerClassSingleton() {
        if (InnerClass.staticInnerClassSingleton != null)
            throw new RuntimeException("单例对象不允许反射生成...");
    }
}
