package com.example.furama.services.contract.impl;

import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.repository.contract.IContractDetailRepository;
import com.example.furama.repository.contract.IContractRepository;
import com.example.furama.services.contract.IContactDetailService;
import com.example.furama.services.contract.IContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContactDetailService {
   @Autowired
    IContractDetailRepository contractDetailRepository;
   @Autowired
    IContractServices contractServices;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);

    }

    @Override
    public List<ContractDetail> findByContract(Long idContract) {
        Contract contract = contractServices.getContractById(idContract);
        return contractDetailRepository.findAllByContract(contract);
    }
}
