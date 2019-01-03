package books.zeroD.chapter2.serialize;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.TProtocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author lw
 * @Date 2019-01-01 14:58:36
 **/
public class User implements Serializable, TBase {

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

    @Override
    public void read(TProtocol iprot) throws TException {

    }

    @Override
    public void write(TProtocol oprot) throws TException {

    }

    @Override
    public TFieldIdEnum fieldForId(int fieldId) {
        return null;
    }

    @Override
    public boolean isSet(TFieldIdEnum field) {
        return false;
    }

    @Override
    public Object getFieldValue(TFieldIdEnum field) {
        return null;
    }

    @Override
    public void setFieldValue(TFieldIdEnum field, Object value) {

    }

    @Override
    public TBase deepCopy() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
