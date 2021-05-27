package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.utilities.observer.Observer;
import com.readysoft.personalwallet.utilities.observer.Subject;

import java.util.List;
import java.util.Optional;

public interface PaymentService extends Subject {

    List<Payment> getAllPaymentWithUserId(int id);
    void addPayment(Payment payment);
    void deleteById(int id);
    Optional<Payment> findById(Integer id);
    void checkPaymentDateDue();
}
