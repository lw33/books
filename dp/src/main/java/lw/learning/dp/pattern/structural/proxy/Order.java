package lw.learning.dp.pattern.structural.proxy;

/**
 * @Author lw
 * @Date 2018-12-14 20:14:03
 **/
public class Order {

    private Object orderInfo;
    private Integer userId;

    public Order() {
    }

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order(Object orderInfo, Integer userId) {
        this.orderInfo = orderInfo;
        this.userId = userId;
    }
}
