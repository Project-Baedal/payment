package com.baedal.payment.domain.model;

import lombok.Builder;
import lombok.Getter;

public class KakaoPayment {

  @Getter
  @Builder
  public static class Request {
    private String partnerOrderId;
    private String partnerUserId;
    private String itemName;
    private Integer quantity;
    private Integer totalAmount;
    private Integer taxFreeAmount;
  }

  @Getter
  @Builder
  public static class Response {

    private String tid;
    private String nextRedirectAppUrl;
    private String nextRedirectMobileUrl;
    private String nextRedirectPcUrl;
    private String androidAppScheme;
    private String iosAppScheme;
    private String createdAt;
  }

}
