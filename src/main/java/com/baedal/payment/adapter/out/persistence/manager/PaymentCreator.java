package com.baedal.payment.adapter.out.persistence.manager;

import com.baedal.payment.adapter.out.persistence.entity.PaymentEntity;
import com.baedal.payment.adapter.out.persistence.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentCreator {

  private final PaymentJpaRepository paymentJpaRepository;

  public PaymentEntity save(PaymentEntity paymentEntity) {
    return paymentJpaRepository.save(paymentEntity);
  }
}
