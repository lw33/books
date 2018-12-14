package books.zeroJ.chapter3.controller;


import books.zeroJ.chapter3.service.Service;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;

/**
 * @Author lw
 * @Date 2018-12-10 21:59:34
 **/

@org.smart4j.framework.annotation.Controller
public class Controller {

    @Inject
    Service service;

    @Action("get:/test")
    public Data test(Param param) {
        return new Data(param);
    }

    @Action("get:/service")
    public Data service(Param param) {
        System.out.println(param);
        return new Data(service.toString());
    }
}
