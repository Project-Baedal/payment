package com.baedal.payment.adapter.out.messaging.adapter;

import com.baedal.payment.adapter.out.messaging.dto.SendOrderValidateDto;
import com.baedal.payment.adapter.out.messaging.mapper.PaymentOutMessageMapper;
import com.baedal.payment.adapter.out.messaging.sender.KafkaSender;
import com.baedal.payment.application.port.out.MessageSenderPort;
import com.baedal.payment.domain.model.SendOrderValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;
  private final PaymentOutMessageMapper paymentMapper;

  @Override
  public void sendOrderValidate(SendOrderValidate.Request req) {
    String orderTransactionId = req.getOrderTransactionId();
    SendOrderValidateDto dto = paymentMapper.orderValidateToDto(orderTransactionId, req);
    kafkaSender.sendMessage("order.orderValidate", orderTransactionId, dto);
  }
}
