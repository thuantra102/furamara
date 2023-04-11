package com.example.furama.services.contract.impl;

import com.example.furama.model.contract.AttachFacility;
import com.example.furama.model.contract.Contract;
import com.example.furama.repository.contract.IAttachFacilityRepository;
import com.example.furama.services.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public AttachFacility getAttachFacilityId(Long id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
