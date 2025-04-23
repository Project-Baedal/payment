package com.baedal.payment.domain.business;

import com.baedal.payment.domain.model.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentValidator {


  public PaymentMethod validatePaymentMethod(String method) {
    try {
      return PaymentMethod.valueOf(method);
    } catch (IllegalArgumentException e) {
      return PaymentMethod.NONE;
    }
  }
}
