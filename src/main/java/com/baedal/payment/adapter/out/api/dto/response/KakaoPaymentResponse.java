package com.baedal.payment.adapter.out.api.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPaymentResponse {

  private String tid;
  private String nextRedirectAppUrl;
  private String nextRedirectMobileUrl;
  private String nextRedirectPcUrl;
  private String androidAppScheme;
  private String iosAppScheme;
  private String createdAt;

}
