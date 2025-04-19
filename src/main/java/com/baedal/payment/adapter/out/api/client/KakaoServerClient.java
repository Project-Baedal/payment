package com.baedal.payment.adapter.out.api.client;

import com.baedal.payment.adapter.out.api.dto.request.KakaoApproveRequest;
import com.baedal.payment.adapter.out.api.dto.request.KakaoPaymentRequest;
import com.baedal.payment.adapter.out.api.dto.response.KakaoApproveResponse;
import com.baedal.payment.adapter.out.api.dto.response.KakaoPaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    name = "kakaoPayClient",
    url = "https://open-api.kakaopay.com"
)
public interface KakaoServerClient {

  @PostMapping(value = "/online/v1/payment/ready", consumes = "application/json")
  KakaoPaymentResponse readyPayment(
      @RequestHeader("Authorization") String authorization,
      @RequestBody KakaoPaymentRequest request
  );

  @PostMapping("/online/v1/payment/approve")
  KakaoApproveResponse approvePayment(
      @RequestHeader("Authorization") String authorization,
      @RequestBody KakaoApproveRequest request
  );

}
