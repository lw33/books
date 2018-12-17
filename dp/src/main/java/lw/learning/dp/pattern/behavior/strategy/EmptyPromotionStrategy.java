package lw.learning.dp.pattern.behavior.strategy;

/**
 * @Author lw
 * @Date 2018-12-17 23:05:37
 **/
public class EmptyPromotionStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("EmptyPromotionStrategy.doPromotion");
    }
}
