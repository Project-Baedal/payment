package com.baedal.payment.adapter.out.persistence.adapter;

import com.baedal.payment.adapter.out.persistence.dto.KakaoPaymentInfoDto;
import com.baedal.payment.adapter.out.persistence.manager.PaymentCacheCreator;
import com.baedal.payment.adapter.out.persistence.manager.PaymentCacheReader;
import com.baedal.payment.adapter.out.persistence.mapper.PaymentPersistenceMapper;
import com.baedal.payment.application.port.out.PaymentCacheRepositoryPort;
import com.baedal.payment.domain.model.KakaoPaymentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentCacheRepository implements PaymentCacheRepositoryPort {

  private final PaymentPersistenceMapper paymentMapper;
  private final PaymentCacheCreator paymentCacheCreator;
  private final PaymentCacheReader paymentCacheReader;

  @Override
  public void savePaymentInfo(KakaoPaymentInfo.Request req) {
    String orderTransactionId = req.getOrderTransactionId();
    KakaoPaymentInfoDto dto = paymentMapper.kakaoPaymentInfoToDto(req);
    paymentCacheCreator.save(orderTransactionId, dto);

  }

  @Override
  public KakaoPaymentInfo.Response getPaymentInfo(String orderTransactionId) {
    KakaoPaymentInfoDto dto = paymentCacheReader.findByKey(orderTransactionId);
    return paymentMapper.kakaoPaymentInfoToDomain(dto);
  }
}
