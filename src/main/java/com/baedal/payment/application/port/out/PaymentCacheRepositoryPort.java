package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.KakaoPaymentInfo;

public interface PaymentCacheRepositoryPort {

  // successKakao
  void savePaymentInfo(KakaoPaymentInfo.Request req);

  // approvePayment
  KakaoPaymentInfo.Response getPaymentInfo(String orderTransactionId);
}
