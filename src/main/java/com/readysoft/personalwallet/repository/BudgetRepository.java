package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
}
