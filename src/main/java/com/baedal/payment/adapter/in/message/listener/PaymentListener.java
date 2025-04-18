package com.baedal.payment.adapter.in.message.listener;

import com.baedal.payment.adapter.in.message.dto.AddPaymentRequest;
import com.baedal.payment.adapter.in.message.mapper.PaymentListenerMapper;
import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.port.in.PaymentUseCase;
import com.baedal.payment.util.Converter;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentListener {

  private final Converter converter;
  private final PaymentListenerMapper mapper;
  private final PaymentUseCase paymentUseCase;


  @KafkaListener(topics = "payment.paymentRequest", groupId = "payment-group")
  public void addPayment(ConsumerRecord<String, String> record) {
    Long orderId = Long.parseLong(record.key());
    AddPaymentRequest req = converter.jsonToDto(record.value(), AddPaymentRequest.class);
    AddPaymentCommand.Request command = mapper.addPaymentToCommand(orderId, req);
    paymentUseCase.addPayment(command);
  }

}
