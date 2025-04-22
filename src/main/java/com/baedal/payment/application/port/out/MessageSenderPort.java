package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.FailKakao;

public interface MessageSenderPort {

  void sendSuccessOrderValidate(String orderTransactionId);

  void sendFailOrderValidate(FailKakao message);
}
