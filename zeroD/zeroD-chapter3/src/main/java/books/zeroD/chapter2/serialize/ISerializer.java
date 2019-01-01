package books.zeroD.chapter2.serialize;

/**
 * @Author lw
 * @Date 2019-01-01 14:50:49
 **/
public interface ISerializer {

    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T obj);


    /**
     * 反序列化
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T deserialize(byte[] data, Class<T> clazz);
}
