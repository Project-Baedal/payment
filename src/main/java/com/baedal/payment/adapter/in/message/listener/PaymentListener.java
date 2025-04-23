package com.baedal.payment.adapter.in.message.listener;

import com.baedal.payment.adapter.in.message.mapper.PaymentListenerMapper;
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

  @KafkaListener(topics = "payment.approvePayment", groupId = "payment-approvePayment")
  public void approvePayment(ConsumerRecord<String, String> record) {
    String orderTransactionId = record.key();
    paymentUseCase.approvePayment(orderTransactionId);
  }


}
