package zeroD.chapter4.model;

import java.io.Serializable;

/**
 * @Author lw
 * @Date 2019-01-01 14:58:36
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -2802627760327835064L;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
