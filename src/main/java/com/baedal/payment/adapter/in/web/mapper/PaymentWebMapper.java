package com.baedal.payment.adapter.in.web.mapper;

import com.baedal.payment.adapter.in.web.dto.request.PayWithKakaoRequest;
import com.baedal.payment.adapter.in.web.dto.request.SuccessKakaoRequest;
import com.baedal.payment.adapter.in.web.dto.response.PayWithKakaoResponse;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import com.baedal.payment.application.command.SuccessKakaoCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentWebMapper {

  // 결제 요청
  PayWithKakaoCommand.Reqeust payWithKakaoToCommand(PayWithKakaoRequest req);
  PayWithKakaoResponse payWithKakaoToResponse(PayWithKakaoCommand.Response res);


  // 결제 성공
  SuccessKakaoCommand.Request successKakaoToCommand(SuccessKakaoRequest req);
}
