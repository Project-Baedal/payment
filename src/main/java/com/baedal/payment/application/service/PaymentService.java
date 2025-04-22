package com.baedal.payment.application.service;

import com.baedal.payment.application.business.PaymentManger;
import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.command.FailKakaoCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;
import com.baedal.payment.application.mapper.PaymentApplicationMapper;
import com.baedal.payment.application.port.in.PaymentUseCase;
import com.baedal.payment.application.port.out.KakaoClientPort;
import com.baedal.payment.application.port.out.MessageSenderPort;
import com.baedal.payment.domain.model.FailKakao;
import com.baedal.payment.domain.model.KakaoPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {

  private final PaymentApplicationMapper paymentMapper;
  private final MessageSenderPort messageSenderPort;
  private final KakaoClientPort kakaoClientPort;

  @Override
  public PayWithKakaoCommand.Response payWithKakao(PayWithKakaoCommand.Reqeust req) {
    KakaoPayment.Request request = paymentMapper.payWithKakaoToDomain(req);
    KakaoPayment.Response response = kakaoClientPort.request(request);
    return paymentMapper.toPayWithKakaoCommand(response);
  }

  @Override
  public void successKakao(SuccessKakaoCommand.Request req) {
    // 결제 성공 메세지 큐 전송
    messageSenderPort.sendSuccessOrderValidate(req.getOrderTransactionId());
  }

  @Override
  public void failKakao(FailKakaoCommand.Request req) {
    FailKakao failKakao = paymentMapper.failKakaoToDomain(req);
    messageSenderPort.sendFailOrderValidate(failKakao);
  }
}
