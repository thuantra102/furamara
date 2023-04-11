package com.example.furama.repository.facility;

import com.example.furama.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Long> {
}
