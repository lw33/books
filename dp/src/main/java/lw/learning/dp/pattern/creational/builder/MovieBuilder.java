package lw.learning.dp.pattern.creational.builder;

/**
 * @Author lw
 * @Date 2018-12-12 20:23:28
 **/
public abstract class MovieBuilder {
  /*  private String name;
    private String script;
    private String duration;
    private String director;
    private String role;*/

    public abstract void buildMovieName(String name);

    public abstract void buildMovieScript(String script);

    public abstract void buildMovieDuration(String duration);

    public abstract void buildMovieDirector(String director);

    public abstract void buildMovieRole(String role);

    public abstract Movie buildMovie();

}
