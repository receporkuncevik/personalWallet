package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.AccumulationCategory;

import java.util.List;
import java.util.Optional;

public interface AccumulationCategoryService {

    List<AccumulationCategory> listAccumulationCategory();
    void addAccumulationCategoy(AccumulationCategory accumulationCategory);
    Optional<AccumulationCategory> findById(int id);
}
