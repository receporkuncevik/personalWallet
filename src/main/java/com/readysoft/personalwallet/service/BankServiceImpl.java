package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Bank;
import com.readysoft.personalwallet.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAllBankWithUserId(int id) {
       return bankRepository.getAllBankWithUserId(id);
    }

    @Override
    public Bank getById(int id) {
        return bankRepository.getOne(id);
    }

    @Override
    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public void delete(Integer id) {
        bankRepository.deleteById(id);
    }
}
