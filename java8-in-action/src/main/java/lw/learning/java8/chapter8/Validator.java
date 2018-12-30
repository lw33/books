package lw.learning.java8.chapter8;

/**
 * @Author lw
 * @Date 2018-12-30 15:00:02
 **/
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numberValidator = new Validator(new IsNumberic());
        System.out.println(numberValidator.validate("aaa"));
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        System.out.println(lowerCaseValidator.validate("bbb"));

        System.out.println(new Validator((s) -> s.matches("[a-z]+")).validate("java"));
    }
}
