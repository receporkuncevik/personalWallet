package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    List<User> userObserverList = new ArrayList<>();
    List<Payment> plannedPaymentList = new ArrayList<>();

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

    @Override
    public void checkPaymentDateDue() {
        for(User userObserver : userObserverList) {
            plannedPaymentList = paymentRepository.getAllPlannedPaymentWihtUserId(userObserver.getId());;
        }

        for(Payment payment : plannedPaymentList){
            LocalDate paymentDate = Instant.ofEpochMilli(payment.getBuyingDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            if(LocalDate.now().getDayOfMonth() == (paymentDate.getDayOfMonth() - 1 )){
                notifyUpdate();
            }
        }
    }

    @Override
    public void attach(User userObserver) {
        userObserverList.add(userObserver);
    }

    @Override
    public void detach(User userObserver) {
        userObserverList.remove(userObserver);

    }

    @Override
    public void notifyUpdate() {
        for(User userObserver : userObserverList){
            userObserver.update();
        }
    }
}
