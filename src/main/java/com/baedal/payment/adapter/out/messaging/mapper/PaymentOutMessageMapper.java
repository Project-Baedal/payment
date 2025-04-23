package com.baedal.payment.adapter.out.messaging.mapper;

import com.baedal.payment.adapter.out.messaging.dto.SendOrderValidateDto;
import com.baedal.payment.adapter.out.messaging.dto.SuccessOrderDto;
import com.baedal.payment.domain.model.SendOrderValidate;
import com.baedal.payment.domain.model.SuccessOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentOutMessageMapper {

  SendOrderValidateDto orderValidateToDto(String orderTransactionId, SendOrderValidate.Request req);

  SuccessOrderDto successOrderToDto(SuccessOrder.Request req);
}
