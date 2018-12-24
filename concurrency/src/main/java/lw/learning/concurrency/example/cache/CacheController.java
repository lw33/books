package lw.learning.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lw
 * @Date 2018-12-23 17:39:58
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    public String set(@RequestParam("k") String k, @RequestParam("v") String v) {
        redisClient.set(k, v);
        return "SUCCESS";
    }

    @RequestMapping("/get")
    public String get(@RequestParam("k") String k) {
        return redisClient.get(k);
    }
    
}
