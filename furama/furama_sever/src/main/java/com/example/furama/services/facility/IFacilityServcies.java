package com.example.furama.services.facility;

import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityServcies {
    List<Facility> findAll();
    Page findByName(String name, Pageable pageable);
    void save (Facility facility);
    void delete(Facility facility);
    Facility getFaciltyById(Long id);
    Page<Facility> getAll(Pageable pageable);
}
