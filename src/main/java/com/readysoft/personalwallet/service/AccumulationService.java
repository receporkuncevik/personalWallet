package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Accumulation;
import com.readysoft.personalwallet.utilities.observer.Subject;

import java.util.List;
import java.util.Optional;

public interface AccumulationService{

    List<Accumulation> getAllAccumulationFromId(int id);
    void saveAccumulation(Accumulation accumulation);
    void deleteById(Integer id);
    Optional<Accumulation> findById(Integer id);
}
