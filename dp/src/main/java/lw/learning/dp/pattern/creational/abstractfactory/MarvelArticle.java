package lw.learning.dp.pattern.creational.abstractfactory;

/**
 * @Author lw
 * @Date 2018-12-10 22:58:55
 **/
public class MarvelArticle extends Article{
    @Override
    void produce() {
        System.out.println("MarvelArticle.produce");
    }
}
