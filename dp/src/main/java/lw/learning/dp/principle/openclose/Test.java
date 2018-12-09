package lw.learning.dp.principle.openclose;

/**
 * @Author lw
 * @Date 2018-12-07 21:38:29
 **/
public class Test {

    public static void main(String[] args) {
        ICourse javaCourse = new JavaCourse(1, "java", 1.1);
        JavaDiscount javaDiscount = new JavaDiscount(2, "javac", 1.12);
        System.out.println(javaCourse);
        System.out.println(javaDiscount.getOriginalPrice());
    }
}
