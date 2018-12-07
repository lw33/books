package lw.learning.books.chapter2.service;

import lw.learning.books.chapter2.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        // TODO 2018/12/7 初始化数据库
    }

    @Test
    public void getCustomerList() {
        List<Customer> customerList = customerService.getCustomerList();
        System.out.println(customerList);
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomer() {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomer() {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "10001");
        boolean customer = customerService.createCustomer(fieldMap);
        Assert.assertTrue(customer);
    }

    @Test
    public void updateCustomer() {
        long id = 1;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "Eric");
        boolean updateCustomer = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(updateCustomer);
    }

    @Test
    public void deleteCustomer() {
        long id = 1;
        boolean deleteCustomer = customerService.deleteCustomer(id);
        Assert.assertTrue(deleteCustomer);
    }
}