package com.baedal.payment.adapter.in.message.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddPaymentRequest {

  private String paymentMethod;
  private int totalAmount;

}
