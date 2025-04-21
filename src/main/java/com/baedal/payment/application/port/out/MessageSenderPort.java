package com.baedal.payment.application.port.out;

import com.baedal.payment.application.command.SendPaymentStatusCommand;

public interface MessageSenderPort {

  void sendPaymentStatus(SendPaymentStatusCommand message);

  void sendSuccessOrderValidate(String orderTransactionId);

  void sendFailOrderValidate(String orderTransactionId, String errorMessage);
}
