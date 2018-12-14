package lw.learning.dp.pattern.structural.proxy;

import lw.learning.dp.pattern.structural.proxy.dynamicproxy.OrderServiceDynamicProxy;

/**
 * @Author lw
 * @Date 2018-12-14 20:43:38
 **/
public class Main {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderService.saveOrder(new Order());
        orderService.toString();
    }
}
