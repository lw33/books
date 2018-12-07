package lw.learning.jmx.s2;

/**
 * @Author lw
 * @Date 2018-12-06 15:43:11
 **/
public class Person implements PersonMBean{

    private String name;
    private int age;
    private String address;

    @Override
    public void changeName(String name) {
        setName(name);
        System.out.println(this);
    }

    @Override
    public void changeAge(int age) {
        setAge(age);
        System.out.println(this);
    }

    @Override
    public void changeAddress(String address) {
        setAddress(address);
        System.out.println(this);
    }

    public String getName() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
