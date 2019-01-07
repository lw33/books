package zeroD.chapter4.service;

import zeroD.chapter4.model.User;

/**
 * @Author lw
 * @Date 2019-01-06 14:36:01
 **/
public interface UserService {
    User findByName(String userName);
}
