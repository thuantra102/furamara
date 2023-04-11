package com.example.furama.services.customer;

import com.example.furama.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeServices {
    List<CustomerType> findAll();
}
