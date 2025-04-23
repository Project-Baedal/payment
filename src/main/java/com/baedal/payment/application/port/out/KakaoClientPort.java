package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.KakaoApprove;
import com.baedal.payment.domain.model.KakaoPayment;

public interface KakaoClientPort {

  KakaoPayment.Response request(KakaoPayment.Request req);

  KakaoApprove.Response approve(KakaoApprove.Request req);

}
