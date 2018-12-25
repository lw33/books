package lw.learning.monitortuning.chapter5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lw
 * @Date 2018-12-24 21:38:44
 **/
@RestController
@RequestMapping("/chapter5")
public class TestController {


    @RequestMapping("/hello")
    public String hello() {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += i;
        }
        return str;
    }
}
