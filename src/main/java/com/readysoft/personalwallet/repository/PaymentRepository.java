package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
