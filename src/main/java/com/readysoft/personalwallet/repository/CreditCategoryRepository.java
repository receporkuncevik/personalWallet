package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.CreditCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCategoryRepository extends JpaRepository<CreditCategory , Integer> {
}
