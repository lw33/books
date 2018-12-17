package lw.learning.dp.pattern.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-17 23:04:17
 **/
public class PromotionFactory {

    private static final Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put("div", new DivPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put("dis", new DiscountPromotionStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION_STRATEGY = new EmptyPromotionStrategy();

    public static PromotionStrategy getPromotionStrategy(String promotion) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotion);
        return promotionStrategy == null ? NON_PROMOTION_STRATEGY : promotionStrategy;
    }
}
