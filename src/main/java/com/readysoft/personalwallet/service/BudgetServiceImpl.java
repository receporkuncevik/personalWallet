package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService{

    @Autowired
    private BudgetRepository budgetRepository;


    @Override
    public List<Budget> getAllBudget() {
        return budgetRepository.findAll();
    }

    @Override
    public void saveBudget(Budget budget) {
        budgetRepository.save(budget);
    }
}
