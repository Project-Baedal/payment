package com.baedal.payment.domain.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Payment {

  private Long id;
  private Long paymentId;
  private Long orderId;
  private String paymentMethod;
  private String paymentStatus;
  private int totalAmount;
  private LocalDateTime createdAt;

}
