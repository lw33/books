package lw.learning.dp.pattern.structural.adapter;

/**
 * @Author lw
 * @Date 2018-12-16 14:50:12
 **/
public class PowerAdapter implements DC5V{

    AC220V ac220V = new AC220V();

    @Override
    public int output5v() {
        int i = ac220V.output220v();
        System.out.println(i + " ---> 5");
        return i / 44;
    }
}
