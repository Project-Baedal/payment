package com.baedal.payment.adapter.out.api.mapper;

import com.baedal.payment.config.KakaoProperties;
import com.baedal.payment.adapter.out.api.dto.request.KakaoPaymentRequest;
import com.baedal.payment.adapter.out.api.dto.response.KakaoPaymentResponse;
import com.baedal.payment.domain.model.KakaoPayment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KakaoApiMapper {

  KakaoPaymentRequest toKakaoPaymentRequest(KakaoProperties kakaoApiMapper, KakaoPayment.Request req);
  KakaoPayment.Response toKakaoPaymentResponse(KakaoPaymentResponse res);
}
