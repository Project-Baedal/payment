package com.baedal.payment.adapter.in.web.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FailKakaoRequest {

  private String orderTransactionId;
  private String errorMessage;
}
