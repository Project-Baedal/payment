package com.baedal.payment.adapter.out.messaging.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SendOrderValidateDto {

  private String domain;
  private boolean status;
  private String errorMessage;

  @Builder
  public SendOrderValidateDto(String errorMessage, boolean status) {
    this.errorMessage = errorMessage;
    this.status = status;
    this.domain = "PAYMENT";
  }
}
