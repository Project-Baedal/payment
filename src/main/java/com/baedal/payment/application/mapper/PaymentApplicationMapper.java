package com.baedal.payment.application.mapper;

import com.baedal.payment.application.command.FailKakaoCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.FailKakao;
import com.baedal.payment.domain.model.KakaoApprove;
import com.baedal.payment.domain.model.KakaoPayment;
import com.baedal.payment.domain.model.PaymentMethod;
import com.baedal.payment.domain.model.PaymentStatus;
import com.baedal.payment.domain.model.SendOrderValidate;
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

  @Mapping(target = "status", expression = "java(false)")
  SendOrderValidate.Request sendOrderValidateToDomain(FailKakaoCommand.Request req);

  @Mapping(target = "orderId", source = "response.partnerOrderId")
  @Mapping(target = "totalAmount", source = "response.amount.total")
  AddPayment KakaApproveToDomain(
      KakaoApprove.Response response, PaymentMethod paymentMethod, PaymentStatus paymentStatus
  );

  // failKakao
  FailKakao failKakaoToDomain(FailKakaoCommand.Request req);
}
