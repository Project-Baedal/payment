package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.SendOrderValidate;
import com.baedal.payment.domain.model.SuccessOrder;

public interface MessageSenderPort {

  void sendOrderValidate(SendOrderValidate.Request req);

  void successOrder(SuccessOrder.Request req);
}
