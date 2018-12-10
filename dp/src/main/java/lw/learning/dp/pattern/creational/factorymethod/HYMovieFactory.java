package lw.learning.dp.pattern.creational.factorymethod;

/**
 * @Author lw
 * @Date 2018-12-10 22:09:49
 **/
public class HYMovieFactory extends MovieFactory{
    @Override
    public Movie getMovie() {
        return new HYMovie();
    }
}
