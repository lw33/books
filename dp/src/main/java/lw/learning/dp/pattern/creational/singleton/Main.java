package lw.learning.dp.pattern.creational.singleton;

import lw.learning.dp.pattern.structural.proxy.OrderServiceImpl;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-14 22:46:50
 **/
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*HungrySingleton instance = HungrySingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton"));
        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);*/

        Runnable runnable = () -> {
            ContainerSingleton.putInstance("java", new Object());
            Object java = ContainerSingleton.getInstance("java");
            System.out.println(java);
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<HungrySingleton> hungrySingletonClass = HungrySingleton.class;
        Constructor<HungrySingleton> declaredConstructor = hungrySingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungrySingleton hungrySingleton = declaredConstructor.newInstance();
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        System.out.println(instance);
        System.out.println(hungrySingleton == instance);
    }

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<StaticInnerClassSingleton> staticInnerClassSingletonClass = StaticInnerClassSingleton.class;
        Constructor<StaticInnerClassSingleton> declaredConstructor = staticInnerClassSingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        StaticInnerClassSingleton staticInnerClassSingleton = declaredConstructor.newInstance();
        System.out.println(staticInnerClassSingleton == StaticInnerClassSingleton.getInstance());
    }

    @Test
    public void test2() throws Exception {
        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new OrderServiceImpl());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton"));
        EnumInstance newInstance = (EnumInstance) ois.readObject();
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
        System.out.println(instance.getData() == newInstance.getData());
        System.out.println(instance.getData());
    }

    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        EnumInstance.INSTANCE.test();
        //EnumInstance.INSTANCE.java();
        EnumInstance instance = EnumInstance.INSTANCE;
        Method java = EnumInstance.class.getMethod("java", null);
        java.invoke(instance, null);
    }

    @Test
    public void test4() {

    }
}
