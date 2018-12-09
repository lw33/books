package lw.learning.dp.principle.dependenceinversion;

/**
 * @Author lw
 * @Date 2018-12-07 22:23:59
 **/
public class JavaCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("JavaCourse");
    }
}
