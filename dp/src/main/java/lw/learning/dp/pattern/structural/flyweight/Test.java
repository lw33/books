package lw.learning.dp.pattern.structural.flyweight;

/**
 * @Author lw
 * @Date 2018-12-16 15:35:12
 **/
public class Test {
    public static final String[] departments = {"java", "c", "python"};
    public static void main(String[] args) {

        int n = 10;
        for (int i = 0; i < n; i++) {
            EmployeeFactory.getManager(departments[(int) (departments.length * Math.random())]).report();
        }
        
        
    }
    @org.junit.Test
    public void test() {
        Integer i = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i == i2);
    }
}
