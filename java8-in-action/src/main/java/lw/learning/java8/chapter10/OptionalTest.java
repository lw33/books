package lw.learning.java8.chapter10;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author lw
 * @Date 2018-12-30 18:08:16
 **/
public class OptionalTest {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName).orElse("QQ");
    }

    @Test
    public void test1() {
        Insurance insurance = new Insurance();
        insurance.setName("Amazing");
        Car car = new Car();
        car.setInsurance(insurance);
        Person person = new Person();
        person.setCar(car);

        System.out.println(getCarInsuranceName(Optional.of(person)));
    }
}
