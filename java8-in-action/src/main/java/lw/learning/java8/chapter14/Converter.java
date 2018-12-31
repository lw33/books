package lw.learning.java8.chapter14;

import java.util.function.DoubleUnaryOperator;

/**
 * @Author lw
 * @Date 2018-12-31 18:13:31
 **/
public class Converter {

    public static double converter(double x, double f, double b) {
        return x * f + b;
    }

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return x -> x * f + b;
    }

    public static void main(String[] args) {
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        System.out.println(convertCtoF.applyAsDouble(37));
    }
}
