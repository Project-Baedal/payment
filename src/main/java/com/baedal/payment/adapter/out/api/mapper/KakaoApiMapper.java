package com.baedal.payment.adapter.out.api.mapper;

import com.baedal.payment.adapter.out.api.dto.request.KakaoApproveRequest;
import com.baedal.payment.adapter.out.api.dto.response.KakaoApproveResponse;
import com.baedal.payment.config.KakaoProperties;
import com.baedal.payment.adapter.out.api.dto.request.KakaoPaymentRequest;
import com.baedal.payment.adapter.out.api.dto.response.KakaoPaymentResponse;
import com.baedal.payment.domain.model.KakaoApprove;
import com.baedal.payment.domain.model.KakaoPayment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KakaoApiMapper {

  // 카카오 결제 요청
  KakaoPaymentRequest toKakaoPaymentRequest(KakaoProperties kakaoApiMapper, KakaoPayment.Request req);
  KakaoPayment.Response toKakaoPaymentResponse(KakaoPaymentResponse res);

  // 카카오 결제 승인
  KakaoApproveRequest toKakaoApproveRequest(KakaoApprove.Request req);
  KakaoApprove.Response toKakaoApproveResponse(KakaoApproveResponse res);
}
