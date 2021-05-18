package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> getAllPaymentWithUserId(int id);
    void addPayment(Payment payment);
    void deleteById(int id);
    Optional<Payment> findById(Integer id);

}
