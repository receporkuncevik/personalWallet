package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.BankAccount;
import com.readysoft.personalwallet.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    @Query("SELECT ba FROM BankAccount ba where ba.user.id = ?1")
    List<BankAccount> getAllBankAccountsWithUserId(int id);


}
