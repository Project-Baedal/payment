package com.baedal.payment.adapter.out.persistence.mapper;

import com.baedal.payment.adapter.out.persistence.entity.PaymentEntity;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentPersistenceMapper {

  PaymentEntity addPaymentToEntity(AddPayment addPayment);

  Payment entityToDomain(PaymentEntity entity);
}
