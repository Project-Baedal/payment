package com.baedal.payment.adapter.in.message.listener;

import com.baedal.payment.adapter.in.message.mapper.PaymentListenerMapper;
import com.baedal.payment.application.port.in.PaymentUseCase;
import com.baedal.payment.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentListener {

  private final Converter converter;
  private final PaymentListenerMapper mapper;
  private final PaymentUseCase paymentUseCase;


}
