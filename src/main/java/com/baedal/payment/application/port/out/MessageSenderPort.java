package com.baedal.payment.application.port.out;

import com.baedal.payment.application.command.SendPaymentStatusCommand;
import com.baedal.payment.domain.model.FailKakao;

public interface MessageSenderPort {

  void sendPaymentStatus(SendPaymentStatusCommand message);

  void sendSuccessOrderValidate(String orderTransactionId);

  void sendFailOrderValidate(FailKakao message);
}
