package lw.learning.books.chapter2.service;

/**
 * @Author lw
 * @Date 2018-12-07 17:22:05
 **/

import lw.learning.books.chapter2.model.Customer;
import lw.learning.books.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 提供客户数据服务
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");
        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");
        DRIVER = driver;
        URL = url;
        USERNAME = username;
        PASSWORD = password;
    }
    /**
     * 获取客户列表
     * @return
     */
    public List<Customer> getCustomerList() {
        // TODO 2018/12/7
        Connection connection = null;

        try {
            List<Customer> customers = new ArrayList<>();
            String sql = "select * from customer";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            LOGGER.error("execute sql failure", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("close connection failure", e);
                }
            }
        }
        return null;
    }

    /**
     * 通过关键字查询用户
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        // TODO 2018/12/7
        return null;
    }

    /**
     * 获取客户
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        // TODO 2018/12/7
        return null;
    }

    /**
     * 创建客户
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        // TODO 2018/12/7
        return false;
    }

    /**
     * 更新客户
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
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        // TODO 2018/12/7
        return false;
    }


}
