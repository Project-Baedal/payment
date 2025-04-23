package com.baedal.payment.application.port.out;

import com.baedal.payment.domain.model.AddPayment;
import com.baedal.payment.domain.model.Payment;

public interface PaymentRepositoryPort {

  Payment save(AddPayment addPayment);
}
