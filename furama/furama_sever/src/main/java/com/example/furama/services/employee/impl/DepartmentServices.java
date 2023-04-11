package com.example.furama.services.employee.impl;

import com.example.furama.model.employee.Department;
import com.example.furama.repository.employee.IDepartmentRepsitory;
import com.example.furama.services.employee.IDepartMentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices implements IDepartMentServices {
    @Autowired
    private IDepartmentRepsitory iDepartmentRepsitory;
    @Override
    public List<Department> findAll() {
        return iDepartmentRepsitory.findAll();
    }
}
