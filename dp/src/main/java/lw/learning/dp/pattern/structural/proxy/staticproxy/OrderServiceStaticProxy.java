package lw.learning.dp.pattern.structural.proxy.staticproxy;

import lw.learning.dp.pattern.structural.proxy.IOrderService;
import lw.learning.dp.pattern.structural.proxy.Order;

/**
 * @Author lw
 * @Date 2018-12-14 20:19:05
 **/
public class OrderServiceStaticProxy implements IOrderService{

    private IOrderService orderService;


    public void before() {
        System.out.println("OrderServiceStaticProxy.before");
    }

    public void after() {
        System.out.println("OrderServiceStaticProxy.after");
    }

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int saveOrder(Order order) {
        before();
        orderService.saveOrder(order);
        after();
        return 0;
    }
}
