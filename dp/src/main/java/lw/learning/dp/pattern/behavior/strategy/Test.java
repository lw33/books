package lw.learning.dp.pattern.behavior.strategy;

/**
 * @Author lw
 * @Date 2018-12-17 22:57:56
 **/
public class Test {
    public static void main(String[] args) {
       /* PromotionActivity p1 = new PromotionActivity(new DiscountPromotionStrategy());
        PromotionActivity p2 = new PromotionActivity(new DivPromotionStrategy());
        p1.executePromotion();
        p2.executePromotion();*/

        PromotionActivity promotionActivity = new PromotionActivity(PromotionFactory.getPromotionStrategy("dis"));
        promotionActivity.executePromotion();
    }
}
