package lw.learning.dp.principle.dependenceinversion;

/**
 * @Author lw
 * @Date 2018-12-07 22:24:23
 **/
public class PythonCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("PythonCourse");
    }
}
