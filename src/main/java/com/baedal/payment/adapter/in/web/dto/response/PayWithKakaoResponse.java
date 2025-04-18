package com.baedal.payment.adapter.in.web.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Builder
public class PayWithKakaoResponse {

  @Schema(description = "결제 고유 번호")
  private String tid;

  @Schema(description = "모바일 앱 URL")
  private String nextRedirectAppUrl;

  @Schema(description = "모바일 웹 URL")
  private String nextRedirectMobileUrl;

  @Schema(description = "웹 URL")
  private String nextRedirectPcUrl;

  @Schema(description = "ANDROID 내부 서비스용")
  private String androidAppScheme;

  @Schema(description = "IOS 내부 서비스용")
  private String iosAppScheme;

  @Schema(description = "결제 준비 요청 시간")
  private String createdAt;
}
