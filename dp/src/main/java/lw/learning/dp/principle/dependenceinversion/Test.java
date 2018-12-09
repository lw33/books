package lw.learning.dp.principle.dependenceinversion;

/**
 * @Author lw
 * @Date 2018-12-07 22:25:14
 **/
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.study(new JavaCourse());
        student.study(new PythonCourse());
    }
}
