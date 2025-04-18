package com.baedal.payment.application.port.in;

import com.baedal.payment.application.command.AddPaymentCommand;

public interface PaymentUseCase {

  void addPayment(AddPaymentCommand.Request req);

}
