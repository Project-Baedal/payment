package com.baedal.payment.domain.model;

import lombok.Builder;
import lombok.Getter;

public class SuccessOrder {

  @Getter
  @Builder
  public static class Request {

    private Long paymentId;
    private String orderTransactionId;

  }

}
