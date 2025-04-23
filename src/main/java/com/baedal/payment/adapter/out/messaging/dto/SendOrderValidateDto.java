package com.baedal.payment.adapter.out.messaging.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SendOrderValidateDto {

  private String domain;
  private boolean status;
  private String message;

  @Builder
  public SendOrderValidateDto(String message, boolean status) {
    this.message = message;
    this.status = status;
    this.domain = "PAYMENT";
  }
}
