package lw.learning.springboot.sbwebmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author lw
 * @Date 2019-02-16 21:01:32
 **/
@Controller
public class HelloController {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("message", "Java");
        return "index";
    }

    @RequestMapping("/f")
    @ResponseBody
    public ResponseEntity<String> f() {
        return ResponseEntity.ok("Hello f");
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");

        return modelAndView;
    }

}
