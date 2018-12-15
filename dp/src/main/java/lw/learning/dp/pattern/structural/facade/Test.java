package lw.learning.dp.pattern.structural.facade;

/**
 * @Author lw
 * @Date 2018-12-15 22:42:15
 **/
public class Test {

    public static void main(String[] args) {
        PointGift gift = new PointGift("java");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.setPointsPaymentService(new PointsPaymentService());
        giftExchangeService.setQualifyService(new QualifyService());
        giftExchangeService.setShippingService(new ShippingService());
        giftExchangeService.giftExchange(gift );
    }
}
