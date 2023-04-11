package com.example.furama.restController;

import com.example.furama.model.contract.AttachFacility;
import com.example.furama.services.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachFacility")
public class AttachFacilityRestController {
    @Autowired
    IAttachFacilityService attachFacilityService;
    @GetMapping("/getAll")
    public List<AttachFacility> getAll(){
        return attachFacilityService.findAll();
    }
    @GetMapping("/findById/{id}")
    public Float getById(@PathVariable("id") Long id) {
        return  attachFacilityService.getAttachFacilityId(id).getPrice();
    }



}
