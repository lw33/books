package lw.learning.dp.principle.dependenceinversion;

/**
 * @Author lw
 * @Date 2018-12-07 22:19:41
 **/
public class Student {

    public void study(ICourse course) {
        course.studyCourse();
    }
}
