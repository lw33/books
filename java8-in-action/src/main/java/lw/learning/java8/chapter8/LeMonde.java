package lw.learning.java8.chapter8;

/**
 * @Author lw
 * @Date 2018-12-30 15:10:54
 **/
public class LeMonde implements Observer{

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
