package com.baedal.payment.application.command;

import lombok.Builder;
import lombok.Getter;

public class AddPaymentCommand {

  @Getter
  @Builder
  public static class Request {

    private Long orderId;
    private String paymentMethod;
    private int totalAmount;
  }

}
