package com.example.furama.services.employee.impl;

import com.example.furama.model.employee.Level;
import com.example.furama.repository.employee.ILevelRepository;
import com.example.furama.services.employee.ILevelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServices  implements ILevelServices {
    @Autowired
    private ILevelRepository iLevelRepository;
    @Override
    public List<Level> findAll() {
        return iLevelRepository.findAll();
    }
}
