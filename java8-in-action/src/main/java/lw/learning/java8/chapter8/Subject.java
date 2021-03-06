package lw.learning.java8.chapter8;

/**
 * @Author lw
 * @Date 2018-12-30 15:11:39
 **/
public interface Subject {

    void registerObserver(Observer observer);

    void notifyObservers(String tweet);
}
