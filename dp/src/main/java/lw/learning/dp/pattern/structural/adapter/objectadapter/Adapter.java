package lw.learning.dp.pattern.structural.adapter.objectadapter;

/**
 * @Author lw
 * @Date 2018-12-16 14:44:27
 **/
public class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
