package lw.learning.java8.chapter8;

/**
 * @Author lw
 * @Date 2018-12-30 14:59:38
 **/
public class IsAllLowerCase implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
