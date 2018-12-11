package lw.learning.dp.pattern.creational.abstractfactory;

/**
 * @Author lw
 * @Date 2018-12-10 23:04:46
 **/
public class Test {

    public static void main(String[] args) {
        MovieFactory movieFactory = new MarvelMovieFactory();
        movieFactory.getArticle().produce();
        movieFactory.getMovie().produce();
    }
}
