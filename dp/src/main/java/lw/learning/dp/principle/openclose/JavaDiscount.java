package lw.learning.dp.principle.openclose;

/**
 * @Author lw
 * @Date 2018-12-07 21:43:31
 **/
public class JavaDiscount extends JavaCourse{

    public JavaDiscount(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {

        return super.getPrice() * 0.8;
    }

    public Double getOriginalPrice() {
        return super.getPrice();
    }
}
