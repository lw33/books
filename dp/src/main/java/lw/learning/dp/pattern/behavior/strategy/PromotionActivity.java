package lw.learning.dp.pattern.behavior.strategy;

/**
 * @Author lw
 * @Date 2018-12-17 22:51:25
 **/
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }


    public void executePromotion() {
        promotionStrategy.doPromotion();
    }


    public void setPromotionStrategy(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;

    }
}
