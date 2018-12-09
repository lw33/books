package lw.learning.books.chapter2.service;

/**
 * @Author lw
 * @Date 2018-12-07 17:22:05
 **/

import lw.learning.books.chapter2.helper.DatabaseHelper;
import lw.learning.books.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     *
     * @return
     */
    public List<Customer> getCustomerList() {
        String sql = "select * from customer";
        List<Customer> customers = DatabaseHelper.queryEntityList(Customer.class, sql);
        return customers;
    }

    /**
     * 通过关键字查询用户
     *
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        // TODO 2018/12/7
        return null;
    }

    /**
     * 获取客户
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        // TODO 2018/12/7
        return null;
    }

    /**
     * 创建客户
     *
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        // TODO 2018/12/7
        return false;
    }

    /**
     * 更新客户
     *
     * @param id
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        // TODO 2018/12/7
        return false;
    }

    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        // TODO 2018/12/7
        return false;
    }


}
