package ssf.miniproject.ssfminiproject.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import ssf.miniproject.ssfminiproject.models.Symbols;

public class TickerRepository {

    @Autowired @Qualifier("redislab")
    private RedisTemplate<String, String> template;
    
    public Optional<List<Symbols>> get(String username) {

        if (!template.hasKey(username))
            return Optional.empty();

        List<Symbols> contents = new LinkedList<>();
        ListOperations<String, String> listOps = template.opsForList();
        long size = listOps.size(username);
        for (long i = 0; i < size; i ++) {
            String str = listOps.index(username, i);
            contents.add(Symbols.create(str));
            System.out.println(">>>>>>" + contents);
        }
        

        return Optional.of(contents);

    }
}
