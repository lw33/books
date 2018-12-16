package lw.learning.dp.pattern.structural.decorator;

/**
 * @Author lw
 * @Date 2018-12-16 14:04:43
 **/
public class IronManDecorator extends AbstractDecorator{

    public IronManDecorator(AHero hero) {
        super(hero);
    }

    @Override
    String getDesc() {
        return super.getDesc() + " Iron Man...";
    }

    @Override
    String skin() {
        return super.skin() + " Iron Man...";
    }

    @Override
    int cost() {
        return super.cost() + 666;
    }
}
