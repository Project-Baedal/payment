package com.baedal.payment.application.port.in;

import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;

public interface PaymentUseCase {

  void addPayment(AddPaymentCommand.Request req);

  PayWithKakaoCommand.Response payWithKakao(PayWithKakaoCommand.Reqeust req);
}
