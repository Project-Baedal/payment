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
    redisTemplate.opsForValue().set(getKey(key), value);
  }

  public Object getKeys(String key) {
    return redisTemplate.opsForValue().get(getKey(key));
  }
}
