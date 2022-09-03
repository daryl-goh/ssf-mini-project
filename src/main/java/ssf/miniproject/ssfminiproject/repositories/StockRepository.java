package ssf.miniproject.ssfminiproject.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;


import ssf.miniproject.ssfminiproject.models.StockNews;


@Repository
public class StockRepository {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    public void save(StockNews newsToSave){
        String symbol = String.valueOf(newsToSave.getSymbol());
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        valueOp.set(symbol, newsToSave.toJson().toString());
        System.out.println("StockRepository: - save symbol: " + symbol + " - SUCCESS!");
  }
    
}
