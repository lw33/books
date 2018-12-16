package lw.learning.dp.pattern.structural.decorator;

/**
 * @Author lw
 * @Date 2018-12-16 14:05:58
 **/
public class Hero extends AHero{
    @Override
    String getDesc() {
        return "a hero ";
    }

    @Override
    String skin() {
        return "skin ";
    }

    @Override
    int cost() {
        return 111;
    }
}
