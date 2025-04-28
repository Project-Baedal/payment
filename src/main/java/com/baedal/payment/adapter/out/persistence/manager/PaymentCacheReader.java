package com.baedal.payment.adapter.out.persistence.manager;

import com.baedal.payment.adapter.out.persistence.dto.KakaoPaymentInfoDto;
import com.baedal.payment.adapter.out.persistence.repository.PaymentRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentCacheReader {

  private final PaymentRedisRepository paymentRedisRepository;

  public KakaoPaymentInfoDto findByKey(String key) {
    return (KakaoPaymentInfoDto) paymentRedisRepository.getKeys(key);
  }
}
