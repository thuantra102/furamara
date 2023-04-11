package com.example.furama.restController;

import com.example.furama.dto.contractDTO.FacilityDTO;
import com.example.furama.services.facility.IFacilityServcies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facility")
public class FacilityRestController {
    @Autowired
    IFacilityServcies facilityServcies;
    @GetMapping("/findById/{id}")
    public FacilityDTO getById(@PathVariable("id") Long id) {
        FacilityDTO facilityDTO = new FacilityDTO();
        BeanUtils.copyProperties(facilityServcies.getFaciltyById(id),facilityDTO);
        return facilityDTO;
    }
}
