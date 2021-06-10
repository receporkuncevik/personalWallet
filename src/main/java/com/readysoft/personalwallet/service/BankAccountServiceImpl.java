package com.readysoft.personalwallet.service;


import com.readysoft.personalwallet.model.BankAccount;
import com.readysoft.personalwallet.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> getAllBankAccountWithUserId(int id) {
        return bankAccountRepository.getAllBankAccountsWithUserId(id);
    }

    @Override
    public void save(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public Optional<BankAccount> findById(int id) {
        return bankAccountRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        bankAccountRepository.deleteById(id);
    }
}
