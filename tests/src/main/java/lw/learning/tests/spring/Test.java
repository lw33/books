package lw.learning.tests.spring;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author lw
 * @Date 2018-12-18 15:51:41
 **/
public class Test {

    @org.junit.Test
    public void test1() {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression("1+1");
        Object value = expression.getValue();
        System.out.println(value);
    }
}
