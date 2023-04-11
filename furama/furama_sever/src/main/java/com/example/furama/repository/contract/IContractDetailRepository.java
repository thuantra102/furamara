package com.example.furama.repository.contract;

import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    public List<ContractDetail> findAllByContract(Contract contract);

}
