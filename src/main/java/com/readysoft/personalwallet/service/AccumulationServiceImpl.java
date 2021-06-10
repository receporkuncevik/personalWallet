package com.readysoft.personalwallet.service;

import com.readysoft.personalwallet.model.Accumulation;
import com.readysoft.personalwallet.repository.AccumulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccumulationServiceImpl implements AccumulationService{

    @Autowired
    private AccumulationRepository accumulationRepository;

    @Override
    public List<Accumulation> getAllAccumulationFromId(int id) {
       return accumulationRepository.getAllAccumulationFromId(id);
    }

    @Override
    public void saveAccumulation(Accumulation accumulation) {
        accumulationRepository.save(accumulation);

    }

    @Override
    public void deleteById(Integer id) {
        accumulationRepository.deleteById(id);
    }

    @Override
    public Optional<Accumulation> findById(Integer id) {
        return accumulationRepository.findById(id);
    }
}
