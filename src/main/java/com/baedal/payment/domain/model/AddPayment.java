package com.baedal.payment.domain.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddPayment {

  private final Long paymentId;
  private final Long orderId;
  private final String paymentMethod;
  private final String paymentStatus;
  private final int totalAmount;
  private final LocalDateTime createdAt;

  @Builder
  public AddPayment(Long paymentId, Long orderId, String paymentMethod, String paymentStatus,
      int totalAmount) {
    this.paymentId = paymentId;
    this.orderId = orderId;
    this.paymentMethod = paymentMethod;
    this.paymentStatus = paymentStatus;
    this.totalAmount = totalAmount;
    this.createdAt = LocalDateTime.now();
  }
}
