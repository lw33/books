package lw.learning.dp.pattern.creational.builder;

/**
 * @Author lw
 * @Date 2018-12-12 20:32:10
 **/
public class Producer {
    private MovieBuilder movieBuilder;

    public Producer() {
    }

    public void setMovieBuilder(MovieBuilder movieBuilder) {
        this.movieBuilder = movieBuilder;
    }

    public Movie createMovie(String name, String script, String duration, String director, String role) {
        movieBuilder.buildMovieName(name);
        movieBuilder.buildMovieScript(script);
        movieBuilder.buildMovieDuration(duration);
        movieBuilder.buildMovieDirector(director);
        movieBuilder.buildMovieRole(role);
        return movieBuilder.buildMovie();
    }
}
