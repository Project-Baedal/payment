package com.baedal.payment.application.service;

import com.baedal.payment.application.business.PaymentManger;
import com.baedal.payment.application.command.AddPaymentCommand;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SendPaymentStatusCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;
import com.baedal.payment.application.mapper.PaymentApplicationMapper;
import com.baedal.payment.application.port.in.PaymentUseCase;
import com.baedal.payment.application.port.out.KakaoClientPort;
import com.baedal.payment.application.port.out.MessageSenderPort;
import com.baedal.payment.application.port.out.PaymentRepositoryPort;
import com.baedal.payment.domain.business.PaymentValidator;
import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.KakaoPayment;
import com.baedal.payment.domain.model.Payment;
import com.baedal.payment.domain.model.PaymentMethod;
import com.baedal.payment.domain.model.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {

  private final PaymentApplicationMapper paymentMapper;
  private final PaymentRepositoryPort paymentRepositoryPort;
  private final PaymentValidator paymentValidator;
  private final PaymentManger paymentManger;
  private final MessageSenderPort messageSenderPort;
  private final KakaoClientPort kakaoClientPort;

  @Override
  @Transactional
  public void addPayment(AddPaymentCommand.Request req) {

    // 유효한 결제 방식인지 검증
    PaymentMethod paymentMethod = paymentValidator.validatePaymentMethod(req.getPaymentMethod());

    // 결제 요청 | 결제 실패시 paymentId 는 NULL
    Integer paymentId = (paymentMethod == PaymentMethod.NONE) ?
        null : paymentManger.requestPayment(req);

    // 결제 성공 여부 체크
    PaymentStatus paymentStatus = (paymentId != null) ?
        PaymentStatus.SUCCESS : PaymentStatus.FAIL;


    //　결제 결과 저장
    AddPayment addPayment = paymentMapper.addPaymentToDomain(
        req, paymentMethod, paymentStatus, paymentId
    );
    Payment payment = paymentRepositoryPort.save(addPayment);

    // 결제 결과 메세지 큐로 전송
//    SendPaymentStatusCommand sendMessage = paymentMapper.toSendPaymentStatusCommand(
//        req.getOrderId(), payment
//    );
//    messageSenderPort.sendPaymentStatus(sendMessage);

  }

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
}
