package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {

    List<BankAccount> getAllBankAccountWithUserId(int id);

    void save(BankAccount bankAccount);

    Optional<BankAccount> findById(int id);

    void deleteById(int id);


}
