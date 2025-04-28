package com.baedal.payment.adapter.in.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SuccessKakaoRequest {

  @Schema(description = "주문 번호")
  private String orderTransactionId;

  @Schema(description = "가맹점 코드", defaultValue = "TC0ONETIME")
  private String cid;

  @Schema(description = "결제 고유 번호")
  private String tid;

  @Schema(description = "결제 승인 토큰")
  private String pgToken;
}
