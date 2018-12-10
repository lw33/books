package lw.learning.dp.pattern.creational.factorymethod;

/**
 * @Author lw
 * @Date 2018-12-10 22:07:42
 **/
public class MarvelMovieFactory extends MovieFactory {

    @Override
    public Movie getMovie() {
        return new MarvelMovie();
    }
}
