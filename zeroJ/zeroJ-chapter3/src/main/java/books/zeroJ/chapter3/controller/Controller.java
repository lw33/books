package books.zeroJ.chapter3.controller;


import books.zeroJ.chapter3.service.Service;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;

/**
 * @Author lw
 * @Date 2018-12-10 21:59:34
 **/

@org.smart4j.framework.annotation.Controller
public class Controller {

    @Inject
    Service service;

    @Action("get:/test")
    public Data test() {
        return new Data("Thinking in java");
    }

    @Action("get:/service")
    public Data service() {
        return new Data(service.toString());
    }
}
