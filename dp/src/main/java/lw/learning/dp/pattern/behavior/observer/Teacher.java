package lw.learning.dp.pattern.behavior.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author lw
 * @Date 2018-12-18 16:09:06
 **/
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(name + "  " + course.getName()+ " " + question.getUserName() + "   " + question.getContent());
    }
}
