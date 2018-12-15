package lw.learning.dp.pattern.structural.facade;

/**
 * @Author lw
 * @Date 2018-12-15 22:36:29
 **/
public class PointsPaymentService {

    public boolean pay(PointGift pointGift) {
        System.out.println("pay " + pointGift.getName());
        return true;
    }
}
