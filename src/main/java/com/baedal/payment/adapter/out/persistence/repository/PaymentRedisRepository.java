package com.baedal.payment.adapter.out.persistence.repository;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRedisRepository {

  private final RedisTemplate<String, Object> redisTemplate;

  private String ORDER_PREFIX = "paymentInfo:";

  private String getKey(String key) {
    return ORDER_PREFIX + key;
  }

  public void save(String key, Object value) {
    redisTemplate.opsForSet().add(getKey(key), value);
  }

  public Object getKeys(String key) {
    return redisTemplate.opsForSet().members(getKey(key));
  }
}
