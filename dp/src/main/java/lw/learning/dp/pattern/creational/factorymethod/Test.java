package lw.learning.dp.pattern.creational.factorymethod;

/**
 * @Author lw
 * @Date 2018-12-08 22:41:39
 **/
public class Test extends DCMovie {
    public static void main(String[] args) {
        MovieFactory factory = new MarvelMovieFactory();
        factory.getMovie().produce();

    }
}
