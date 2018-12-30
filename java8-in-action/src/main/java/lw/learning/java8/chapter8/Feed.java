package lw.learning.java8.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-30 15:12:28
 **/
public class Feed implements Subject{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.registerObserver(System.out::println);
        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
