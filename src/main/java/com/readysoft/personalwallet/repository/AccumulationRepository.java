package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Accumulation;
import com.readysoft.personalwallet.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccumulationRepository extends JpaRepository<Accumulation , Integer> {

    @Query("SELECT a FROM Accumulation a where a.user.id = ?1")
    List<Accumulation> getAllAccumulationFromId(int id);
}
