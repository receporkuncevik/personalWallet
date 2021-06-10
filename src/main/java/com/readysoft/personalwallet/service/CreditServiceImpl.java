package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Credit;
import com.readysoft.personalwallet.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CreditServiceImpl implements CreditService{
    @Autowired
    private CreditRepository creditRepository;

    @Override
    public List<Credit> getAllCreditFromId(int id) {
        return creditRepository.getAllCreditFromId(id);
    }

    @Override
    public void saveCredit(Credit credit) {
        creditRepository.save(credit);

    }

    @Override
    public Optional<Credit> findById(Integer id) {
        return creditRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        creditRepository.deleteById(id);

    }
}
