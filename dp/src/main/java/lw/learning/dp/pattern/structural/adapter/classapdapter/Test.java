package lw.learning.dp.pattern.structural.adapter.classapdapter;

/**
 * @Author lw
 * @Date 2018-12-16 14:43:00
 **/
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreateTarget();
        Target target1 = new TargetAdapter();
        target.request();
        target1.request();
    }
}
