package books.zeroJ.chapter5.controller;

import books.zeroJ.chapter5.model.Customer;
import books.zeroJ.chapter5.service.CustomerService;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;

import java.util.List;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-19 14:31:52
 **/
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;


    /**
     * 进入 客户列表 界面
     */
    @Action("get:/customer")
    public View index() {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    @Action("post:/customer_create")
    public Data createSumit(Param param) {
        Map<String, Object> filedMap = param.getFieldMap();
        FileParam fileParam = param.getFile("photo");
        boolean result = customerService.createCustomer(filedMap, fileParam);
        return new Data(result);
    }

    @Action("get:/customer_create")
    public View getCustomerCreate() {
        return new View("customer_create.jsp");
    }
}
