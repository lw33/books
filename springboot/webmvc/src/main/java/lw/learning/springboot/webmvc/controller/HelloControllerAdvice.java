package lw.learning.springboot.webmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author lw
 * @Date 2019-02-16 21:01:32
 **/
@ControllerAdvice(assignableTypes = HelloController.class)
public class HelloControllerAdvice {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("message", "Java");
        return "index";
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");

        return modelAndView;
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }
     @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
        return jsessionId;
    }

}
