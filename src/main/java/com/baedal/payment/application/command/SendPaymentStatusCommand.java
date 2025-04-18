package com.baedal.payment.application.command;

import com.baedal.payment.domain.model.PaymentStatus;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SendPaymentStatusCommand {

  private Long orderId;
  private Long paymentId;
  private PaymentStatus paymentStatus;
  private LocalDateTime createdAt;

}
