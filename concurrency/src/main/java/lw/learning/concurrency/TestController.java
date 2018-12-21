package lw.learning.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lw
 * @Date 2018-12-21 11:02:50
 **/
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    public static void main(String[] args) {
        log.error("java");
    }
}
