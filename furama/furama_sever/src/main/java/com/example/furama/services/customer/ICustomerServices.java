package com.example.furama.services.customer;

import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerServices {
    Page findByName(String name, Pageable pageable);
    void save (Customer customer);
    void delete(Customer customer);
    Customer getCustomerById(int id);
    Page<Customer> getAll(Pageable pageable);
    List<Customer> getAllList();
}
