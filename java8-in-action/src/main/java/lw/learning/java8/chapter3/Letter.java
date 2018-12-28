package lw.learning.java8.chapter3;

/**
 * @Author lw
 * @Date 2018-12-28 15:15:26
 **/
public class Letter {

    public static String addHeader(String text) {
        return "From lw: " + text;
    }

    public static String addFooter(String text) {
        return text + " f regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
