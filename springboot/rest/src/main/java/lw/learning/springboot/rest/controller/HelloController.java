package lw.learning.springboot.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

/**
 * @Author lw
 * @Date 2019-02-18 12:34:31
 **/
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World ";
    }

    @PostMapping(value = "/msg", consumes = "text/properties")
    public Properties msg(Properties properties) {
        return properties;
    }

    @GetMapping("/f")
    public String f() {
        return "index";
    }
}
