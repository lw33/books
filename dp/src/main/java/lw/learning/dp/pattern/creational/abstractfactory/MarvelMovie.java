package lw.learning.dp.pattern.creational.abstractfactory;

/**
 * @Author lw
 * @Date 2018-12-10 22:58:09
 **/
public class MarvelMovie extends Movie{
    @Override
    public void produce() {
        System.out.println("MarvelMovie.produce");
    }
}
