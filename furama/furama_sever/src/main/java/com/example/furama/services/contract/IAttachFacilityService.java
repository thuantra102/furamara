package com.example.furama.services.contract;

import com.example.furama.model.contract.AttachFacility;
import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachFacilityService {

    AttachFacility getAttachFacilityId(Long id);
    Page<Contract> getAll(Pageable pageable);
    List<AttachFacility> findAll();
}
