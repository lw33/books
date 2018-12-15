package lw.learning.dp.pattern.creational.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-15 00:33:12
 **/
public class ContainerSingleton {

    private static Map<String, Object> singletonMap = new HashMap<>();

    public static void putInstance(String key, Object instance) {
        if (StringUtils.isNoneBlank(key)) {
            if (!singletonMap.containsKey(key) && instance != null) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return singletonMap.get(key);
    }
}
