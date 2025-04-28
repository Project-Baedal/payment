package com.baedal.payment.domain.model;

import lombok.Builder;
import lombok.Getter;

public class KakaoPaymentInfo {

  @Getter
  @Builder
  public static class Request {

    private String cid;
    private String tid;
    private String pgToken;
    private String orderTransactionId;
    private String partnerUserId;

  }

  @Getter
  @Builder
  public static class Response {

    private String cid;
    private String tid;
    private String pgToken;
    private String orderTransactionId;
    private String partnerUserId;

  }
}
