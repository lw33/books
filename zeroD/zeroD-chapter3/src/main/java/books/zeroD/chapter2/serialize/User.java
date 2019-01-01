package books.zeroD.chapter2.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author lw
 * @Date 2019-01-01 14:58:36
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -2802627760327835064L;
    private String name;
    private int age;
    transient private String gender;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        gender = in.readUTF();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(gender);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
