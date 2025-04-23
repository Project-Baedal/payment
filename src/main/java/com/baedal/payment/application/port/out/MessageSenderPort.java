package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.SendOrderValidate;

public interface MessageSenderPort {

  void sendOrderValidate(SendOrderValidate.Request req);

}
