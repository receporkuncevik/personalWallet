package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p where p.user.id = ?1")
    List<Payment> getAllPaymentWithUserId(int id);

    @Query("Select p FROM Payment p WHERE p.user.id = ?1 and p.isPlannedPayment=true")
    List<Payment> getAllPlannedPaymentWihtUserId(int id);

    @Query("SELECT p FROM Payment p WHERE p.category.id=?1")
    List<Payment> getByCategory(int categoryId);

    @Query("SELECT p FROM Payment p WHERE p.user.id=?1 ORDER BY p.id DESC")
    List<Payment> getAllPaymentDescendingOrderWithUserId(int id);

}
