package lw.learning.dp.pattern.creational.simplefactory;

/**
 * @Author lw
 * @Date 2018-12-08 22:41:39
 **/
public class Test extends DCMovie {
    public static void main(String[] args) {
        MovieFactory factory = new MovieFactory();
        factory.getMovie(MarvelMovie.class).produce();

    }
}
