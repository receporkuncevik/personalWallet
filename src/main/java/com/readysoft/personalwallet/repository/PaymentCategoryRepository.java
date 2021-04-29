package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, Integer> {
}
