package lw.learning.dp.pattern.creational.builder.v2;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * @Author lw
 * @Date 2018-12-12 20:52:12
 **/
public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie.MovieBuilder()
                .buildMovieName("java")
                .buildMovieScript("javac")
                .buildMovieDuration("javap")
                .buildMovieDirector("lw")
                .buildMovieRole("lw")
                .build();
        //Movie movie1 = new Movie();
        System.out.println(movie);
        Set<String> set = ImmutableSet.<String>builder().add("java").build();
        System.out.println(set);
    }
}
