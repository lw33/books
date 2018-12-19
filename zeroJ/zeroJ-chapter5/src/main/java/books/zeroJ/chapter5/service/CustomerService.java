package books.zeroJ.chapter5.service;

import books.zeroJ.chapter5.model.Customer;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.helper.UploadHelper;

import java.util.List;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-19 14:32:20
 **/
@Service
public class CustomerService {

    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        if (result) {
            UploadHelper.uploadFile("D:/tmp/", fileParam);
        }
        return result;
    }
    /**
     * 获取客户列表
     */
    @Transaction
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

}
