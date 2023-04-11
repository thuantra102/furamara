package com.example.furama.restController;

import com.example.furama.dto.contractDTO.ContractDetailDTO;
import com.example.furama.model.contract.AttachFacility;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.services.contract.IContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contractDetail")
public class ContractDetailRestController {
    @Autowired
    IContactDetailService contactDetailService;

    @PostMapping("/save")
    public ResponseEntity<?> saveService(@RequestBody ContractDetailDTO contractDetailDTO) {
        ContractDetail contractDetail = new ContractDetail();
       contractDetail.setContract(new Contract(contractDetailDTO.getIdContract()));
       contractDetail.setAttachFacility(new AttachFacility(contractDetailDTO.getIdAttachFacility()));
       contractDetail.setQuantity(contractDetailDTO.getQuality());
       contactDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping("/find/{id}")
    public List<ContractDetail> findByContract(@PathVariable Long id) {
        return contactDetailService.findByContract(id);
    }
}
