package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {

    @Query("SELECT b FROM Budget b where b.user.id = ?1")
    List<Budget> getAllBudgetFromId(int id);


}
