package books.zeroD.chapter2.serialize;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

/**
 * @Author lw
 * @Date 2019-01-02 16:26:34
 **/
public class ThriftSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        try {
            if (!(obj instanceof TBase)) {
                throw new UnsupportedOperationException("not supported obj type");
            }
            TSerializer tSerializer = new TSerializer(new TBinaryProtocol.Factory());
            return tSerializer.serialize((TBase) obj);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            if (!TBase.class.isAssignableFrom(clazz)) {
                throw new UnsupportedOperationException("not supported obj type");
            }

            TBase tBase = (TBase) clazz.newInstance();

            TDeserializer tDeserializer = new TDeserializer(new TBinaryProtocol.Factory());
            tDeserializer.deserialize(tBase, data);
            return (T) tBase;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
