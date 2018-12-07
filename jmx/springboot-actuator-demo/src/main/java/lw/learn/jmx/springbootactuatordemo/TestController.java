package lw.learn.jmx.springbootactuatordemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lw
 * @Date 2018-12-06 14:01:16
 **/
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "Thinking in Java";
    }

}
