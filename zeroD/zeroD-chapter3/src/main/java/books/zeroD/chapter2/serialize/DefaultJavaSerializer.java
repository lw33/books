package books.zeroD.chapter2.serialize;

import java.io.*;

/**
 * @Author lw
 * @Date 2019-01-01 14:52:36
 **/
public class DefaultJavaSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
             return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
