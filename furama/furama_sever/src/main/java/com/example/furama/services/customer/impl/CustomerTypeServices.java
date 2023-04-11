package com.example.furama.services.customer.impl;

import com.example.furama.model.customer.CustomerType;
import com.example.furama.repository.customer.ICustomerTypeRepository;
import com.example.furama.services.customer.ICustomerTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServices implements ICustomerTypeServices {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
