package lw.learning.concurrency.example.publish;

import lw.learning.concurrency.annotation.NotRecommend;
import lw.learning.concurrency.annotation.NotThreadSafe;

/**
 * @Author lw
 * @Date 2018-12-21 21:21:37
 **/
@NotThreadSafe
@NotRecommend
public class Escape {


    static {
        integer = 0;
    }
    static Integer integer = null;

    private int thisCanEscape = 0;

    public Escape(){
        new InnerClass();
        thisCanEscape = 1;
        System.out.println(thisCanEscape);
    }

    class InnerClass {
        public InnerClass() {
            System.out.println(Escape.this.thisCanEscape);
        }
    }

    public static Integer getInteger() {
        return integer;
    }
    public static void main(String[] args) {
        Escape escape = new Escape();
        System.out.println(Escape.integer);
    }
}
