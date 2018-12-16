package lw.learning.dp.pattern.behavior.templatemethod;

/**
 * @Author lw
 * @Date 2018-12-16 20:34:34
 **/
public class Test {

    public static void main(String[] args) {
        ACourse dsCourse = new DSCourse();
        dsCourse.makeCourse();
        ACourse feCourse = new FECourse();
        feCourse.makeCourse();
    }
}
