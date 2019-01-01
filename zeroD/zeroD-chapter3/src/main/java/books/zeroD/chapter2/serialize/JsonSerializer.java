package books.zeroD.chapter2.serialize;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author lw
 * @Date 2019-01-01 15:41:46
 **/
public class JsonSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONBytes(obj, SerializerFeature.WRITE_MAP_NULL_FEATURES);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(data, clazz);
    }
}
