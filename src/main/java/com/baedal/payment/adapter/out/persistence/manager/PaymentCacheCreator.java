package com.baedal.payment.adapter.out.persistence.manager;

import com.baedal.payment.adapter.out.persistence.repository.PaymentRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentCacheCreator {

  private final PaymentRedisRepository paymentRedisRepository;

  public void save(String key, Object value) {
    paymentRedisRepository.save(key, value);
  }
}
