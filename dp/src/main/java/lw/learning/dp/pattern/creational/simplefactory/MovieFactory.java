package lw.learning.dp.pattern.creational.simplefactory;

/**
 * @Author lw
 * @Date 2018-12-08 22:39:17
 **/
public class MovieFactory {

    /*public Movie getMovie(String movie) {
        if ("marvel".equalsIgnoreCase(movie)) {
            return new MarvelMovie();
        } else if ("dc".equalsIgnoreCase(movie)) {
            return new MarvelMovie();
        }
        return null;
    }*/

    public Movie getMovie(Class<? extends Movie> c) {
        Movie movie = null;
        try {
            movie = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return movie;
    }
}
