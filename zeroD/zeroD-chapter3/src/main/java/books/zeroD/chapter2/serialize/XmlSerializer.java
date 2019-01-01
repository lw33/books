package books.zeroD.chapter2.serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Author lw
 * @Date 2019-01-01 15:17:21
 **/
public class XmlSerializer implements ISerializer{
    private static final XStream XStream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {

        return XStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String xml = new String(data);
        return (T) XStream.fromXML(xml);
    }
}
