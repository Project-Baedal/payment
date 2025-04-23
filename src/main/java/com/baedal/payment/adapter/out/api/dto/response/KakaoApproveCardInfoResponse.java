package com.baedal.payment.adapter.out.api.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoApproveCardInfoResponse {

  private String cardNo;  // 카드 번호
  private String cardType;  // 카드 종류
  private String cardIssuer;  // 카드 발급사
  private String cardCompany;  // 카드 회사

}
