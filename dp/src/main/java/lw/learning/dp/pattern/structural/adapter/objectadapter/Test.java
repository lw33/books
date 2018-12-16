package lw.learning.dp.pattern.structural.adapter.objectadapter;



/**
 * @Author lw
 * @Date 2018-12-16 14:43:00
 **/
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreateTarget();
        Adapter adapter = new Adapter(new Adaptee());
        target.request();
        adapter.request();
    }
}
