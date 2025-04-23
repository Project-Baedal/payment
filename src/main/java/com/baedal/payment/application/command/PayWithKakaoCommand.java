package com.baedal.payment.application.command;

import lombok.Builder;
import lombok.Getter;

public class PayWithKakaoCommand {

  @Getter
  @Builder
  public static class Reqeust {
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
