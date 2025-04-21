package com.baedal.payment.adapter.out.messaging.adapter;

import com.baedal.payment.adapter.out.messaging.dto.SendOrderValidate;
import com.baedal.payment.adapter.out.messaging.mapper.PaymentOutMessageMapper;
import com.baedal.payment.adapter.out.messaging.sender.KafkaSender;
import com.baedal.payment.application.command.SendPaymentStatusCommand;
import com.baedal.payment.application.port.out.MessageSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;
  private final PaymentOutMessageMapper paymentMapper;

  @Override
  public void sendPaymentStatus(SendPaymentStatusCommand message) {
    String orderId = message.getOrderId().toString();
    kafkaSender.sendMessage("order.sendPaymentStatus", orderId, message);
  }

  @Override
  public void sendSuccessOrderValidate(String orderTransactionId) {
    SendOrderValidate req = paymentMapper.orderValidate(true, null);
    kafkaSender.sendMessage("order.orderValidate", orderTransactionId, req);
  }

  @Override
  public void sendFailOrderValidate(String orderTransactionId, String errorMessage) {
    SendOrderValidate req = paymentMapper.orderValidate(false, errorMessage);
    kafkaSender.sendMessage("order.orderValidate", orderTransactionId, req);
  }
}
