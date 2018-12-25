package lw.learning.monitortuning.chapter8;

/**
 * @Author lw
 * @Date 2018-12-25 19:44:44
 **/
public class TryFinally {

    public static void main(String[] args) {

    }

    public static String f() {
        String str = "hello";

        try {
            return str;
        } finally {
            str = "java";
        }
    }
}
