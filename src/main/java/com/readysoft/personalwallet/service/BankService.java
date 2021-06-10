package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAllBankWithUserId(int id);
    Bank getById(int id);
    void save(Bank bank);
    void delete(Integer id);

}
