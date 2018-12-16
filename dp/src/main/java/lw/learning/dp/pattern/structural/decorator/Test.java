package lw.learning.dp.pattern.structural.decorator;

/**
 * @Author lw
 * @Date 2018-12-16 14:06:31
 **/
public class Test {

    public static void main(String[] args) {

        AHero aHero = new IronManDecorator(new Hero());
        System.out.println(aHero.skin());
        System.out.println(aHero.cost());
        IronManDecorator ironManDecorator = new IronManDecorator(aHero);
        System.out.println(ironManDecorator.skin());
        System.out.println(ironManDecorator.cost());
    }
}
