package com.baedal.payment.adapter.out.messaging;

import com.baedal.payment.application.command.SendPaymentStatusCommand;
import com.baedal.payment.application.port.out.MessageSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;

  @Override
  public void sendPaymentStatus(SendPaymentStatusCommand message) {
    String orderId = message.getOrderId().toString();
    kafkaSender.sendMessage("order.sendPaymentStatus", orderId, message);
  }
}
