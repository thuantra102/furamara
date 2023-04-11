package com.example.furama.services.customer.impl;

import com.example.furama.model.customer.Customer;
import com.example.furama.repository.customer.ICustomerRepository;
import com.example.furama.services.customer.ICustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices implements ICustomerServices {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page findByName(String name, Pageable pageable) {
        return iCustomerRepository.findByNameContains(name,pageable);
    }

    @Override
    public void save(Customer customer) {
            iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
            iCustomerRepository.delete(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }
    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> getAllList() {
        return iCustomerRepository.findAll();
    }
}
