package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService{

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<Budget> getAllBudgetFromId(int id) {
        return budgetRepository.getAllBudgetFromId(id);
    }

    @Override
    public void saveBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    @Override
    public Optional<Budget> findById(Integer id) {
        return budgetRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        budgetRepository.deleteById(id);
    }



}
