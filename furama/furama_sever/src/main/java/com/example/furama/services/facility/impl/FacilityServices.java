package com.example.furama.services.facility.impl;

import com.example.furama.model.facility.Facility;
import com.example.furama.repository.facility.IFacilityRepository;
import com.example.furama.services.facility.IFacilityServcies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityServices implements IFacilityServcies {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page findByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void delete(Facility facility) {
        iFacilityRepository.delete(facility);
    }

    @Override
    public Facility getFaciltyById(Long id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Facility> getAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }
}
