package lw.learning.dp.pattern.structural.decorator;

/**
 * @Author lw
 * @Date 2018-12-16 14:03:19
 **/
public class AbstractDecorator extends AHero{

    private AHero hero;

    public AbstractDecorator(AHero hero) {
        this.hero = hero;
    }

    @Override
    String getDesc() {
        return hero.getDesc();
    }

    @Override
    String skin() {
        return hero.skin();
    }

    @Override
    int cost() {
        return hero.cost();
    }
}
