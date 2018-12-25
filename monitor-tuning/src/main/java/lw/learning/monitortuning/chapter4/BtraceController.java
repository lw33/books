package lw.learning.monitortuning.chapter4;

import lw.learning.monitortuning.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lw
 * @Date 2018-12-24 19:57:55
 **/
@RestController
@RequestMapping("/btrace")
public class BtraceController {


    @RequestMapping("/test")
    public String test(String name) {
        return "hello " + name;
    }

    @RequestMapping("/constructor")
    public User constructor(User user) {
        return user;
    }
}
