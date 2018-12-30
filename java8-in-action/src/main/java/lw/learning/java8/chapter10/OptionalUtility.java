package lw.learning.java8.chapter10;

import java.util.Optional;
import java.util.Properties;

/**
 * @Author lw
 * @Date 2018-12-30 19:20:23
 **/
public class OptionalUtility {

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable((String) props.get(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);

    }
}
