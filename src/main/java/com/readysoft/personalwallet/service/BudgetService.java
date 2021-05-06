package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Budget;

import java.util.List;
import java.util.Optional;

public interface BudgetService {
    List<Budget> getAllBudgetFromId(int id);
    void saveBudget(Budget budget);
    Optional<Budget> findById(Integer id);
    void deleteById(Integer id);
}
