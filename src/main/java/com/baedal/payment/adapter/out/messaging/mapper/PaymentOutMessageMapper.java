package com.baedal.payment.adapter.out.messaging.mapper;

import com.baedal.payment.adapter.out.messaging.dto.SendOrderValidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentOutMessageMapper {

  SendOrderValidate orderValidate(boolean status, String errorMessage);

}
