package lw.learning.java8.chapter10.optional;

import java.util.Optional;

/**
 * @Author lw
 * @Date 2018-12-30 18:11:01
 **/
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
