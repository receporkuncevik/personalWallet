package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> listPayment();
    void addPayment(Payment payment);

}
