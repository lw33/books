package lw.learning.java8.chapter8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @Author lw
 * @Date 2018-12-30 15:31:16
 **/
public class Pipeline {
    public static void main(String[] args) {
        UnaryOperator<String> headerProcessing = text -> "From lw: " + text;
        UnaryOperator<String> spellCheckerProcessing = text -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        System.out.println(pipeline.apply("java labda"));
    }
}
