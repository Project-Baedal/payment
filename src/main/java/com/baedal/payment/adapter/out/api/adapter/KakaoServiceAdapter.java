package com.baedal.payment.adapter.out.api.adapter;

import com.baedal.payment.adapter.out.api.client.KakaoServerClient;
import com.baedal.payment.adapter.out.api.dto.request.KakaoApproveRequest;
import com.baedal.payment.adapter.out.api.dto.response.KakaoApproveResponse;
import com.baedal.payment.config.KakaoProperties;
import com.baedal.payment.adapter.out.api.dto.request.KakaoPaymentRequest;
import com.baedal.payment.adapter.out.api.dto.response.KakaoPaymentResponse;
import com.baedal.payment.adapter.out.api.mapper.KakaoApiMapper;
import com.baedal.payment.application.port.out.KakaoClientPort;
import com.baedal.payment.domain.model.KakaoApprove;
import com.baedal.payment.domain.model.KakaoPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KakaoServiceAdapter implements KakaoClientPort {

  private final KakaoProperties kakaoProperties;

  private final KakaoApiMapper kakaoApiMapper;

  private final KakaoServerClient kakaoServerClient;

  @Override
  public KakaoPayment.Response request(KakaoPayment.Request req) {
    KakaoPaymentRequest request = kakaoApiMapper.toKakaoPaymentRequest(
        kakaoProperties, req
    );
    KakaoPaymentResponse response = kakaoServerClient.readyPayment(
        kakaoProperties.getSecretKeyDev(), request
    );

    return kakaoApiMapper.toKakaoPaymentResponse(response);
  }

  @Override
  public KakaoApprove.Response approve(KakaoApprove.Request req) {
    KakaoApproveRequest request = kakaoApiMapper.toKakaoApproveRequest(req);
    KakaoApproveResponse response = kakaoServerClient.approvePayment(
        kakaoProperties.getSecretKeyDev(), request
    );
    return kakaoApiMapper.toKakaoApproveResponse(response);
  }
}
