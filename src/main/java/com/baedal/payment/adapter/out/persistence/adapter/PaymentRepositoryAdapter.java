package com.baedal.payment.adapter.out.persistence.adapter;

import com.baedal.payment.adapter.out.persistence.entity.PaymentEntity;
import com.baedal.payment.adapter.out.persistence.manager.PaymentCreator;
import com.baedal.payment.adapter.out.persistence.mapper.PaymentPersistenceMapper;
import com.baedal.payment.application.port.out.PaymentRepositoryPort;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepositoryPort {

  private final PaymentPersistenceMapper paymentMapper;
  private final PaymentCreator paymentCreator;

  @Override
  public Payment save(AddPayment addPayment) {
    PaymentEntity entity = paymentMapper.addPaymentToEntity(addPayment);
    paymentCreator.save(entity);
    return paymentMapper.entityToDomain(entity);
  }
}
