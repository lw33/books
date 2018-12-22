package lw.learning.concurrency.example.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lw
 * @Date 2018-12-22 01:29:46
 **/
@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    public Long test() {
        return RequestHolder.getId();
    }
}
