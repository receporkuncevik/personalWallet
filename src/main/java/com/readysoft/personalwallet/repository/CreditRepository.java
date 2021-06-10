package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Integer> {

    @Query("SELECT c FROM Credit c WHERE c.user.id = ?1")
    List<Credit> getAllCreditFromId(int id);
}
