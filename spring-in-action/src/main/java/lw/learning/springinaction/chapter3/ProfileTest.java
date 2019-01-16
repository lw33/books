package lw.learning.springinaction.chapter3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author lw
 * @Date 2019-01-15 22:11:41
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DSConfig.class)
@ActiveProfiles("prod")
public class ProfileTest {

    //@Autowired
    //private String ds;

    @Autowired
    private String java;

    @Test
    public void test() {
        //System.out.println(ds);
        System.out.println(java);
    }
}
