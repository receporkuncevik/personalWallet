package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.CreditCategory;
import com.readysoft.personalwallet.repository.CreditCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CreditCategoryServiveImpl implements CreditCategoryService{

    @Autowired
    private CreditCategoryRepository creditCategoryRepository;

    @Override
    public List<CreditCategory> listCreditCategories() {
        return creditCategoryRepository.findAll();
    }

    @Override
    public void addCreditCategory(CreditCategory creditCategory) {
        creditCategoryRepository.save(creditCategory);

    }

    @Override
    public Optional<CreditCategory> findById(int id) {
        return creditCategoryRepository.findById(id);
    }
}
