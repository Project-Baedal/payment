package com.baedal.payment.adapter.out.messaging.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SuccessOrderDto {

  private Long paymentId;
  private String orderTransactionId;

}
