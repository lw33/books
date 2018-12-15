package lw.learning.dp.pattern.structural.facade;

/**
 * @Author lw
 * @Date 2018-12-15 22:37:13
 **/
public class ShippingService {

    public String shipGift(PointGift gift) {
        System.out.println(gift.getName() + " send");
        return "666";
    }
}
