package com.baedal.payment.adapter.in.message.mapper;

import com.baedal.payment.adapter.in.message.dto.AddPaymentRequest;
import com.baedal.payment.application.command.AddPaymentCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentListenerMapper {

  // 결제 추가
  AddPaymentCommand.Request addPaymentToCommand(Long orderId, AddPaymentRequest req);

}
