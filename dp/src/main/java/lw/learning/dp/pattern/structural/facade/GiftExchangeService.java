package lw.learning.dp.pattern.structural.facade;

/**
 * @Author lw
 * @Date 2018-12-15 22:39:12
 **/
public class GiftExchangeService {

    private QualifyService qualifyService;
    private PointsPaymentService pointsPaymentService;
    private ShippingService shippingService;

    public void setQualifyService(QualifyService qualifyService) {
        this.qualifyService = qualifyService;
    }

    public void setPointsPaymentService(PointsPaymentService pointsPaymentService) {
        this.pointsPaymentService = pointsPaymentService;
    }

    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void giftExchange(PointGift pointGift) {
        if (qualifyService.isAvaliable(pointGift)) {
            if (pointsPaymentService.pay(pointGift)) {
                System.out.println(shippingService.shipGift(pointGift));
                System.out.println("success...");
            }
        }
    }
}
