package com.example.furama.services.employee;

import com.example.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeServices {
    List<Employee> findAll();
    Page findByName(String name, Pageable pageable);
    void save (Employee employee);
    void delete(Employee employee);
    Employee getEmployeeById(int id);
    Page<Employee> getAll(Pageable pageable);
}
