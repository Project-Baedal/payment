package com.baedal.payment.adapter.out.messaging.mapper;

import com.baedal.payment.adapter.out.messaging.dto.SendOrderValidateDto;
import com.baedal.payment.domain.model.SendOrderValidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentOutMessageMapper {

  SendOrderValidateDto orderValidateToDto(String orderTransactionId, SendOrderValidate.Request req);

}
