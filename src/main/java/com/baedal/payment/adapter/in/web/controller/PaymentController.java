package com.baedal.payment.adapter.in.web.controller;

import com.baedal.payment.adapter.in.web.dto.request.PayWithKakaoRequest;
import com.baedal.payment.adapter.in.web.dto.response.PayWithKakaoResponse;
import com.baedal.payment.adapter.in.web.mapper.PaymentWebMapper;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.port.in.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment/kakao")
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentWebMapper paymentMapper;
  private final PaymentUseCase paymentUseCase;

  @PostMapping("/pay")
  public PayWithKakaoResponse payWithKakao(@RequestBody PayWithKakaoRequest req) {
    PayWithKakaoCommand.Reqeust command = paymentMapper.payWithKakaoToCommand(req);
    PayWithKakaoCommand.Response response = paymentUseCase.payWithKakao(command);
    return paymentMapper.payWithKakaoToResponse(response);
  }
}
