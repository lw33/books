package lw.learning.dp.pattern.structural.proxy;

/**
 * @Author lw
 * @Date 2018-12-14 20:15:36
 **/
public class OrderServiceImpl implements IOrderService{
    @Override
    public int saveOrder(Order order) {
        System.out.println("OrderServiceImpl.saveOrder");
        return 0;
    }
}
