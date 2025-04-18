package com.baedal.payment.adapter.in.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PayWithKakaoRequest {

  @Schema(description = "주문 번호")
  private String partnerOrderId;

  @Schema(description = "가맹점 회원 ID")
  private String partnerUserId;

  @Schema(description = "상품명")
  private String itemName;

  @Schema(description = "상품 수량")
  private Integer quantity;

  @Schema(description = "상품 총액")
  private Integer totalAmount;

  @Schema(description = "상품 비과세 금액")
  private Integer taxFreeAmount;

}
