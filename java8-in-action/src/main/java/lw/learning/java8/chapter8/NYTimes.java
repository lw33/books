package lw.learning.java8.chapter8;

/**
 * @Author lw
 * @Date 2018-12-30 15:09:02
 **/
public class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
