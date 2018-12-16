package lw.learning.dp.pattern.structural.adapter.classapdapter;

/**
 * @Author lw
 * @Date 2018-12-16 14:42:18
 **/
public class ConcreateTarget implements Target{
    @Override
    public void request() {
        System.out.println("ConcreateTarget.request");
    }
}
