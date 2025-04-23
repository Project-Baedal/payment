package com.baedal.payment.adapter.out.persistence.mapper;

import com.baedal.payment.adapter.out.persistence.dto.KakaoPaymentInfoDto;
import com.baedal.payment.adapter.out.persistence.entity.PaymentEntity;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.KakaoPaymentInfo;
import com.baedal.payment.domain.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentPersistenceMapper {

  PaymentEntity addPaymentToEntity(AddPayment.Request addPayment);

  Payment entityToDomain(PaymentEntity entity);

  // savePaymentInfo
  KakaoPaymentInfoDto kakaoPaymentInfoToDto(KakaoPaymentInfo.Request req);

  // getPaymentInfo
  KakaoPaymentInfo.Response kakaoPaymentInfoToDomain(KakaoPaymentInfoDto dto);
}
