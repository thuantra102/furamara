package com.example.furama.services.facility.impl;

import com.example.furama.model.facility.FacilityType;
import com.example.furama.repository.facility.IFacilityTypeRepository;
import com.example.furama.services.facility.IFacilityTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeServices implements IFacilityTypeServices {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
