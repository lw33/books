package lw.learning.dp.pattern.behavior.strategy;

/**
 * @Author lw
 * @Date 2018-12-17 22:50:33
 **/
public class DiscountPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("DiscountPromotionStrategy.doPromotion");
    }
}
