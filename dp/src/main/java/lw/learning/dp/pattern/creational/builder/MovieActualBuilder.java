package lw.learning.dp.pattern.creational.builder;

/**
 * @Author lw
 * @Date 2018-12-12 20:29:58
 **/
public class MovieActualBuilder extends MovieBuilder {
    private Movie movie = new Movie();
    @Override
    public void buildMovieName(String name) {
        movie.setName(name);
    }

    @Override
    public void buildMovieScript(String script) {
        movie.setScript(script);
    }

    @Override
    public void buildMovieDuration(String duration) {
        movie.setDuration(duration);
    }

    @Override
    public void buildMovieDirector(String director) {
        movie.setDirector(director);
    }

    @Override
    public void buildMovieRole(String role) {
        movie.setRole(role);
    }

    @Override
    public Movie buildMovie() {

        return movie;
    }
}
