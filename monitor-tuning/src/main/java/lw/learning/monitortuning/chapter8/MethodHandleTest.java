package lw.learning.monitortuning.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author lw
 * @Date 2018-12-27 22:27:27
 **/
public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println("ClassA.println " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        int i = 0;
        while (i < 11) {
            Object o = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
            getPrintlnMH(o).invokeExact("javac");
            i++;
        }
    }

    public static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", methodType).bindTo(reveiver);
    }
}
