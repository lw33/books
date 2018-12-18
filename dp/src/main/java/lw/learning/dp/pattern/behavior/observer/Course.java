package lw.learning.dp.pattern.behavior.observer;

import java.util.Observable;

/**
 * @Author lw
 * @Date 2018-12-18 16:08:45
 **/
public class Course extends Observable {

    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUserName() + "  " + course.getName());
        setChanged();
        notifyObservers(question);
    }
}
