package com.baedal.payment.application.mapper;

import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SendPaymentStatusCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.KakaoApprove;
import com.baedal.payment.domain.model.KakaoPayment;
import com.baedal.payment.domain.model.Payment;
import com.baedal.payment.domain.model.PaymentMethod;
import com.baedal.payment.domain.model.PaymentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentApplicationMapper {

  // addPayment
  @Mapping(target = "paymentMethod", source = "paymentMethod")
  AddPayment addPaymentToDomain(
      AddPaymentCommand.Request req, PaymentMethod paymentMethod,
      PaymentStatus paymentStatus, Integer paymentId
  );

  @Mapping(target = "paymentId", source = "payment.id")
  SendPaymentStatusCommand toSendPaymentStatusCommand(Payment payment);


  // payWithKakao
  KakaoPayment.Request payWithKakaoToDomain(PayWithKakaoCommand.Reqeust req);
  PayWithKakaoCommand.Response toPayWithKakaoCommand(KakaoPayment.Response payment);

  // successKakao
  KakaoApprove.Request successKakaoToDomain(SuccessKakaoCommand.Request req);

  @Mapping(target = "orderId", source = "response.partnerOrderId")
  @Mapping(target = "totalAmount", source = "response.amount.total")
  AddPayment KakaApproveToDomain(
      KakaoApprove.Response response, PaymentMethod paymentMethod, PaymentStatus paymentStatus
  );
}
