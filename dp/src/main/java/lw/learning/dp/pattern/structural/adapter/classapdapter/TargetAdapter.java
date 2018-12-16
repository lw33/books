package lw.learning.dp.pattern.structural.adapter.classapdapter;

/**
 * @Author lw
 * @Date 2018-12-16 14:42:43
 **/
public class TargetAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
