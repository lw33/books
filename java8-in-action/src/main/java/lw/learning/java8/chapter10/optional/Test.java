package lw.learning.java8.chapter10.optional;

import java.util.Optional;

/**
 * @Author lw
 * @Date 2018-12-30 18:26:15
 **/
public class Test {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("!!");
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance666(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }



        public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    @org.junit.Test
    public void test() {
        System.out.println(getCarInsuranceName(Optional.empty()));
        Insurance insurance = new Insurance();
        insurance.setName("Java");
        Optional<Insurance> optionalInsurance = Optional.of(insurance);
        optionalInsurance.filter(ins -> "Java".equals(ins.getName())).ifPresent((insurance1 -> System.out.println(insurance1.getName() + "8 in action")));

    }
}
