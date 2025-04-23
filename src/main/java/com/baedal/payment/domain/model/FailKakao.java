package com.baedal.payment.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FailKakao {

  private String orderTransactionId;
  private String errorMessage;

}
