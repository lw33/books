package lw.learning.dp.pattern.behavior.strategy;

/**
 * @Author lw
 * @Date 2018-12-17 22:51:04
 **/
public class DivPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("DivPromotionStrategy.doPromotion");
    }
}
