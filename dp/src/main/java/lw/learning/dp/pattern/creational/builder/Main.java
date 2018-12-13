package lw.learning.dp.pattern.creational.builder;

/**
 * @Author lw
 * @Date 2018-12-12 20:35:21
 **/
public class Main {

    public static void main(String[] args) {
        MovieBuilder movieBuilder = new MovieActualBuilder();
        Producer producer = new Producer();
        producer.setMovieBuilder(movieBuilder);
        Movie movie = producer.createMovie("amazing", "spider", "man", "the", "j");
        System.out.println(movie);
    }
}
