package lw.learning.dp.pattern.creational.builder;

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


}
