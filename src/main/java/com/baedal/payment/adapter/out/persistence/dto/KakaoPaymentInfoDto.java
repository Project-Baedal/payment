package com.baedal.payment.adapter.out.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KakaoPaymentInfoDto {

  private String cid;
  private String tid;
  private String pgToken;
  private String orderTransactionId;
  private String partnerUserId;
}
