package com.example.furama.repository.employee;

import com.example.furama.model.employee.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILevelRepository extends JpaRepository<Level,Integer> {
}
