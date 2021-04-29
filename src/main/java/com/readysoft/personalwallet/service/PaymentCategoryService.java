package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.PaymentCategory;

import java.util.List;

public interface PaymentCategoryService {
    List<PaymentCategory> listPaymentCategories();
    void addPaymentCategory(PaymentCategory paymentCategory);
}
