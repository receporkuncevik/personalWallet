package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.User;

import java.util.List;

public interface BudgetService {
    List<Budget> getAllBudgetFromId(int id);
    void saveBudget(Budget budget);
}
