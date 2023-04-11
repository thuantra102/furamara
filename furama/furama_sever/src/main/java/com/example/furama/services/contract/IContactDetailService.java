package com.example.furama.services.contract;

import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;

import java.util.List;

public interface IContactDetailService {
    void save (ContractDetail contractDetail);
    List<ContractDetail> findByContract(Long idContract);
}
