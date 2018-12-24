package lw.learning.concurrency.example.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @Author lw
 * @Date 2018-12-23 17:33:35
 **/
@Component
public class RedisClient {

    @Resource(name = "redisPool")
    private JedisPool jedisPool;

    public void set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
    }

    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }
}
