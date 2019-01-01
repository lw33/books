package books.zeroD.chapter2.serialize;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Author lw
 * @Date 2019-01-01 15:56:57
 **/
public class HessianSerializer implements ISerializer{
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        HessianOutput hout = new HessianOutput(bout);
        try {
            hout.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bout.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        HessianInput hessianInput = new HessianInput(new ByteArrayInputStream(data));
        try {
            return (T) hessianInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
