package lw.learning.dp.pattern.creational.builder.v2;

/**
 * @Author lw
 * @Date 2018-12-12 20:21:14
 **/
public class Movie {

    private String name;
    private String script;
    private String duration;
    private String director;
    private String role;

    private Movie(MovieBuilder movieBuilder) {
        this.name = movieBuilder.name;
        this.script = movieBuilder.script;
        this.duration = movieBuilder.duration;
        this.director = movieBuilder.director;
        this.role = movieBuilder.role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", script='" + script + '\'' +
                ", duration='" + duration + '\'' +
                ", director='" + director + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class MovieBuilder {
        private String name;
        private String script;
        private String duration;
        private String director;
        private String role;

        public MovieBuilder buildMovieName(String name) {
            this.name = name;
            return this;
        }

        public MovieBuilder buildMovieScript(String script) {
            this.script = script;
            return this;
        }

        public MovieBuilder buildMovieDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public MovieBuilder buildMovieDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder buildMovieRole(String role) {
            this.role = role;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
