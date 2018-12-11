package lw.learning.dp.pattern.creational.abstractfactory;

/**
 * @Author lw
 * @Date 2018-12-10 22:57:25
 **/
public class MarvelMovieFactory implements MovieFactory{
    @Override
    public Movie getMovie() {
        return new MarvelMovie();
    }

    @Override
    public Article getArticle() {
        return new MarvelArticle();
    }
}
