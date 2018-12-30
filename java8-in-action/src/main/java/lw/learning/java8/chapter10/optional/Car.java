package lw.learning.java8.chapter10.optional;

import java.util.Optional;

/**
 * @Author lw
 * @Date 2018-12-30 18:11:05
 **/
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
