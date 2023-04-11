package com.example.furama.services.employee.impl;

import com.example.furama.model.employee.Position;
import com.example.furama.repository.employee.IPositionRepository;
import com.example.furama.services.employee.IPositionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServices implements IPositionServices {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
