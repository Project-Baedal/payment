package com.baedal.payment.application.port.in;

import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.command.FailKakaoCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;

public interface PaymentUseCase {

  void addPayment(AddPaymentCommand.Request req);

  PayWithKakaoCommand.Response payWithKakao(PayWithKakaoCommand.Reqeust req);

  void successKakao(SuccessKakaoCommand.Request req);

  void failKakao(FailKakaoCommand.Request req);
}
