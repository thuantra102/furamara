package com.example.furama.repository.employee;

import com.example.furama.model.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepsitory extends JpaRepository<Department,Integer> {
}
