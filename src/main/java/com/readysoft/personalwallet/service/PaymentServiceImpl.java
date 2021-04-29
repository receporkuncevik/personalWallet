package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> listPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
