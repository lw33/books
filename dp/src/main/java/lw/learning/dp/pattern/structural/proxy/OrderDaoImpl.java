package lw.learning.dp.pattern.structural.proxy;

/**
 * @Author lw
 * @Date 2018-12-14 20:15:26
 **/
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insertOrder(Order order) {
        System.out.println("OrderDaoImpl.insertOrder");
        return 0;
    }
}
