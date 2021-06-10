package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.CreditCategory;
import com.readysoft.personalwallet.model.PaymentCategory;

import java.util.List;
import java.util.Optional;

public interface CreditCategoryService {
    List<CreditCategory> listCreditCategories();
    void addCreditCategory(CreditCategory creditCategory);
    Optional<CreditCategory> findById(int id);

}
