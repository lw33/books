package lw.learning.jmx.s2;

/**
 * @Author lw
 * @Date 2018-12-06 15:43:37
 **/
public interface PersonMBean {

    void changeName(String name);

    void changeAge(int age);

    void changeAddress(String address);
}
