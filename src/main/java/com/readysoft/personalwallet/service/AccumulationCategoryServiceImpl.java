package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.AccumulationCategory;
import com.readysoft.personalwallet.repository.AccumulationCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccumulationCategoryServiceImpl implements AccumulationCategoryService{

    @Autowired
    private AccumulationCategoryRepository accumulationCategoryRepository;

    @Override
    public List<AccumulationCategory> listAccumulationCategory() {
        return accumulationCategoryRepository.findAll();
    }

    @Override
    public void addAccumulationCategoy(AccumulationCategory accumulationCategory) {
        accumulationCategoryRepository.save(accumulationCategory);
    }

    @Override
    public Optional<AccumulationCategory> findById(int id) {
        return accumulationCategoryRepository.findById(id);
    }
}
