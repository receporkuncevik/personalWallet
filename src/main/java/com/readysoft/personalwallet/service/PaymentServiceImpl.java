package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Payment> getAllPaymentWithUserId(int id) {
        return paymentRepository.getAllPaymentWithUserId(id);
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentRepository.findById(id);
    }


}
