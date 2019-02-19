package lw.learning.springboot.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lw
 * @Date 2019-02-17 15:55:44
 **/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

 @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @ModelAttribute("message")
    public String message() {
        return "HelloWorld";
    }
}
