package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Credit;

import java.util.List;
import java.util.Optional;

public interface CreditService {
    List<Credit> getAllCreditFromId(int id);
    void saveCredit(Credit credit);
    Optional<Credit> findById(Integer id);
    void deleteById(Integer id);
}
