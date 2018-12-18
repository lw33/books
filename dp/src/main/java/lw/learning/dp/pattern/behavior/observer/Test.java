package lw.learning.dp.pattern.behavior.observer;

/**
 * @Author lw
 * @Date 2018-12-18 16:22:46
 **/
public class Test {
    public static void main(String[] args) {
        Course course = new Course("java");
        Teacher teacher = new Teacher("lw");
        course.addObserver(teacher);
        course.produceQuestion(course, new Question("lw", "javac"));
        course.produceQuestion(course, new Question("l", "jav"));
    }
}
