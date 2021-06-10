package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank,Integer> {

    @Query("SELECT b FROM Bank b where b.user.id = ?1")
    List<Bank> getAllBankWithUserId(int id);

}
