package com.baedal.payment.adapter.out.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoApproveAmountResponse {

  private Integer total;  // 전체 결제 금액
  private Integer taxFree;  // 비과세 금액
  private Integer vat;  // 부가세 금액
  private Integer point;  // 사용한 포인트 금액
  private Integer discount;  // 할인 금액
  private Integer greenDeposit;  // 컵 보증금

}
