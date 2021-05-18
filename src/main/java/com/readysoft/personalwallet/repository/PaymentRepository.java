package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p where p.user.id = ?1")
    List<Payment> getAllPaymentWithUserId(int id);

}
