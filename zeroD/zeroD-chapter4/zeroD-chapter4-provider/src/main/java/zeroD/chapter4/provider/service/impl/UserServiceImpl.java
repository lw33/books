package zeroD.chapter4.provider.service.impl;

import org.springframework.stereotype.Service;
import zeroD.chapter4.model.User;
import zeroD.chapter4.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-01-06 14:10:46
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("lw", new User("lw", "lw@qq.com"));
        userMap.put("java", new User("java", "java@qq.com"));
    }

    @Override
    public User findByName(String userName) {
        return userMap.get(userName);
    }

}
