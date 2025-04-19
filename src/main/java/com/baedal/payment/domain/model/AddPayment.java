package com.baedal.payment.domain.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddPayment {

  private final String tid;
  private final Long orderId;
  private final String paymentMethod;
  private final String paymentStatus;
  private final int totalAmount;
  private final LocalDateTime createdAt;

  @Builder
  public AddPayment(String tid, Long orderId, String paymentMethod, String paymentStatus,
      int totalAmount, LocalDateTime createdAt) {
    this.tid = tid;
    this.orderId = orderId;
    this.paymentMethod = paymentMethod;
    this.paymentStatus = paymentStatus;
    this.totalAmount = totalAmount;
    this.createdAt = createdAt;
  }
}
