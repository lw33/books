package lw.learning.springboot.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * {@link CalculateService}
 *
 * @Author lw
 * @Date 2019-02-16 10:42:27
 **/
@Service
@Profile("java8")
public class Java8CalculateService implements CalculateService {


    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java8CalculateService.sum");
        return Stream.of(values).reduce(0, Integer::sum);
    }
}
