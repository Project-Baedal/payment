package com.baedal.payment.domain.model;

import lombok.Builder;
import lombok.Getter;

public class SendOrderValidate {

  @Getter
  @Builder
  public static class Request {

    private String orderTransactionId;
    private boolean status;
    private String message;

  }
}
