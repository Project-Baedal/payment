package com.baedal.payment.application.command;

import lombok.Builder;
import lombok.Getter;

public class SuccessKakaoCommand {

  @Getter
  @Builder
  public static class Request {

    private String cid;
    private String tid;
    private String pgToken;
    private String partnerOrderId;
    private String partnerUserId;
  }
}
