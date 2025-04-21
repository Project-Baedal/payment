package com.baedal.payment.application.command;

import lombok.Builder;
import lombok.Getter;


public class FailKakaoCommand {

  @Getter
  @Builder
  public static class Request {
    private String orderTransactionId;
    private String errorMessage;
  }

}
