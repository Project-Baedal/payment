package com.baedal.payment.application.mapper;

import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.command.SendPaymentStatusCommand;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.Payment;
import com.baedal.payment.domain.model.PaymentMethod;
import com.baedal.payment.domain.model.PaymentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentApplicationMapper {

  @Mapping(target = "paymentMethod", source = "paymentMethod")
  AddPayment addPaymentToDomain(
      AddPaymentCommand.Request req, PaymentMethod paymentMethod,
      PaymentStatus paymentStatus, Integer paymentId
  );

  @Mapping(target = "paymentId", source = "payment.id")
  SendPaymentStatusCommand toSendPaymentStatusCommand(Long orderId, Payment payment);
}
