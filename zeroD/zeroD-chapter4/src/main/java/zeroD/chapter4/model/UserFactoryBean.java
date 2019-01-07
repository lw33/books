package zeroD.chapter4.model;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author lw
 * @Date 2019-01-06 13:36:26
 **/
public class UserFactoryBean implements FactoryBean<User> {

    private static final User user = new User();
    private String name;
    private String email;

    @Override
    public User getObject() throws Exception {
        user.setName(name);
        user.setEmail(email);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
