package com.baedal.payment.adapter.out.api.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPaymentRequest {

  private String cid;
  private String partnerOrderId;
  private String partnerUserId;
  private String itemName;
  private Integer quantity;
  private Integer totalAmount;
  private Integer taxFreeAmount;
  private String approvalUrl;
  private String cancelUrl;
  private String failUrl;

}
