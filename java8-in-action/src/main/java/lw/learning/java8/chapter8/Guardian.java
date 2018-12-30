package lw.learning.java8.chapter8;

/**
 * @Author lw
 * @Date 2018-12-30 15:09:59
 **/
public class Guardian implements Observer{
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another new in London... " + tweet);
        }
    }
}
