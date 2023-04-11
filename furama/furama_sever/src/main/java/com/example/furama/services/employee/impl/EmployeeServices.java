package com.example.furama.services.employee.impl;

import com.example.furama.model.employee.Employee;
import com.example.furama.repository.employee.IEmployeeRepository;
import com.example.furama.services.employee.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices implements IEmployeeServices {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page findByName(String name, Pageable pageable) {
        return iEmployeeRepository.findByNameContains(name,pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        iEmployeeRepository.delete(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }
}
