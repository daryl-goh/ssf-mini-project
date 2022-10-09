package ssf.miniproject.ssfminiproject.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redislab;

    public RedisRepository(RedisTemplate redisTemplate) {
        this.redislab = redisTemplate;
    }

    public void add(final String key, final String value) {
        redislab.opsForList().rightPush(key.toUpperCase(), value);
    }

    public List<String> get(final String key) {
        return redislab.opsForList().range(key.toUpperCase(), 0, -1);
    }

    // public boolean delete(final String key) {
    //     return redislab.delete(key.toUpperCase());
    // }

    public boolean remove(final String key, final String value) {
        Long count = redislab.opsForList().remove(key.toUpperCase(), -1, value);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
