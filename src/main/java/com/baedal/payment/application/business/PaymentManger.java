package com.baedal.payment.application.business;

import com.baedal.payment.application.command.AddPaymentCommand;
import org.springframework.stereotype.Component;

@Component
public class PaymentManger {

  public int requestPayment(AddPaymentCommand.Request req) {
    return 0;
  }

}
