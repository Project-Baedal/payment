package com.baedal.payment.domain.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddPayment {

  @Builder
  public static class Request {

    private final String tid;
    private final String orderTransactionId;
    private final PaymentMethod paymentMethod;
    private final PaymentStatus paymentStatus;
    private final int totalAmount;
    private final LocalDateTime createdAt;

  }
}
