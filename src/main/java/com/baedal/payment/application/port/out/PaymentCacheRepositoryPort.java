package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.KakaoPaymentInfo;

public interface PaymentCacheRepositoryPort {

  void savePaymentInfo(KakaoPaymentInfo.Request req);
}
