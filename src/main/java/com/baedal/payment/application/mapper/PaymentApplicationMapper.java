package com.baedal.payment.application.mapper;

import com.baedal.payment.application.command.FailKakaoCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.KakaoApprove;
import com.baedal.payment.domain.model.KakaoPayment;
import com.baedal.payment.domain.model.KakaoPaymentInfo;
import com.baedal.payment.domain.model.Payment;
import com.baedal.payment.domain.model.PaymentMethod;
import com.baedal.payment.domain.model.PaymentStatus;
import com.baedal.payment.domain.model.SendOrderValidate;
import com.baedal.payment.domain.model.SuccessOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentApplicationMapper {

  // payWithKakao
  KakaoPayment.Request payWithKakaoToDomain(PayWithKakaoCommand.Reqeust req);
  PayWithKakaoCommand.Response toPayWithKakaoCommand(KakaoPayment.Response payment);

  // successKakao
  @Mapping(target = "status", expression = "java(true)")
  SendOrderValidate.Request sendOrderValidateToDomain(SuccessKakaoCommand.Request req);
  KakaoPaymentInfo.Request kakaoPaymentInfoToDomain(SuccessKakaoCommand.Request req);

  // failKakao
  @Mapping(target = "status", expression = "java(false)")
  SendOrderValidate.Request sendOrderValidateToDomain(FailKakaoCommand.Request req);


  // approvePayment
  KakaoApprove.Request kakaoApproveToDomain(KakaoPaymentInfo.Response res);

  @Mapping(target = "tid", source = "res.tid")
  @Mapping(target = "orderTransactionId", source = "res.partnerOrderId")
  @Mapping(target = "totalAmount", source = "res.amount.total")
  @Mapping(target = "createdAt", source = "res.createdAt")
  AddPayment.Request addPaymentKakaoToDomain(
      KakaoApprove.Response res, PaymentMethod paymentMethod, PaymentStatus paymentStatus
  );

  @Mapping(target = "paymentId", source = "id")
  @Mapping(target = "orderTransactionId", source = "orderId")
  SuccessOrder.Request approveToSuccessOrder(Payment payment);
}
