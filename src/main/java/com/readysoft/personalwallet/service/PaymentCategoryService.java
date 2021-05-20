package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.PaymentCategory;

import java.util.List;
import java.util.Optional;

public interface PaymentCategoryService {
    List<PaymentCategory> listPaymentCategories();
    void addPaymentCategory(PaymentCategory paymentCategory);
    Optional<PaymentCategory> findById(int id);

}
