package lw.books.htw.test;

import org.apache.catalina.Container;
import org.apache.catalina.core.StandardContext;

/**
 * @Author lw
 * @Date 2018-12-09 17:52:18
 **/
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        Container container = new StandardContext();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
