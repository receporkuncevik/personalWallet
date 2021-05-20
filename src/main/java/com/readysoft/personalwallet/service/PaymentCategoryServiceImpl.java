package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.PaymentCategory;
import com.readysoft.personalwallet.repository.PaymentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PaymentCategoryServiceImpl implements PaymentCategoryService{

    @Autowired
    private PaymentCategoryRepository paymentCategoryRepository;


    @Override
    public List<PaymentCategory> listPaymentCategories() {
        return paymentCategoryRepository.findAll();
    }

    @Override
    public void addPaymentCategory(PaymentCategory paymentCategory) {
        paymentCategoryRepository.save(paymentCategory);
    }

    @Override
    public Optional<PaymentCategory> findById(int id) {
        return paymentCategoryRepository.findById(id);
    }
}
