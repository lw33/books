package books.zeroD.chapter2.serialize;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Author lw
 * @Date 2019-01-01 15:23:10
 **/
public class XML2Serializer implements ISerializer{

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLEncoder xe = new XMLEncoder(out, "utf-8", true, 0);
        xe.writeObject(obj);
        xe.close();
        return out.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        XMLDecoder xd = new XMLDecoder(new ByteArrayInputStream(data));
        Object o = xd.readObject();
        xd.close();
        return (T) o;
    }
}
