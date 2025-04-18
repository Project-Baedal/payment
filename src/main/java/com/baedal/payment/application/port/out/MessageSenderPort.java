package com.baedal.payment.application.port.out;

import com.baedal.payment.application.command.SendPaymentStatusCommand;

public interface MessageSenderPort {

  void sendPaymentStatus(SendPaymentStatusCommand message);
}
