package com.baedal.payment.adapter.in.web.mapper;

import com.baedal.payment.adapter.in.web.dto.request.PayWithKakaoRequest;
import com.baedal.payment.adapter.in.web.dto.response.PayWithKakaoResponse;
import com.baedal.payment.application.command.PayWithKakaoCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentWebMapper {

  PayWithKakaoCommand.Reqeust payWithKakaoToCommand(PayWithKakaoRequest req);
  PayWithKakaoResponse payWithKakaoToResponse(PayWithKakaoCommand.Response res);
}
