package com.baedal.payment.adapter.out.api.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoApproveRequest {

  private String cid;  // 가맹점 코드
  private String tid;  // 결제 고유번호
  private String partnerOrderId;  // 가맹점 주문번호
  private String partnerUserId;  // 가맹점 회원 ID
  private String pgToken;  // 결제승인 요청 인증 토큰

}
