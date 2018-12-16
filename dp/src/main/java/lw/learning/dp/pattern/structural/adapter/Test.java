package lw.learning.dp.pattern.structural.adapter;

/**
 * @Author lw
 * @Date 2018-12-16 14:51:17
 **/
public class Test {

    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter();
        System.out.println(powerAdapter.output5v());
    }
}
