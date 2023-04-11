package com.example.furama.controller;

import com.example.furama.dto.contractDTO.ContractDto;
import com.example.furama.dto.contractDTO.CustomerDTO;
import com.example.furama.dto.contractDTO.FacilityDTO;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.customer.Customer;
import com.example.furama.services.contract.impl.ContractServices;
import com.example.furama.services.customer.impl.CustomerServices;
import com.example.furama.services.facility.impl.FacilityServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractServices contractServices;
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private FacilityServices facilityServices;

    @ModelAttribute("customerList")
    public List<CustomerDTO> getCustomer() {
        return customerServices.getAllList().stream().map(item -> {
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(item,customerDTO);
            return customerDTO;
        }).collect(Collectors.toList());
    }

    @ModelAttribute("facilityList")
    public List<FacilityDTO> getFacilityDTOList() {
        return facilityServices.findAll().stream().map(item -> {
            FacilityDTO facilityDTO = new FacilityDTO();
            BeanUtils.copyProperties(item,facilityDTO);
            return facilityDTO;
        }).collect(Collectors.toList());
    }
//    @PostMapping("/save")


    @GetMapping("")
    public String getContract(Model model,@RequestParam(value = "page",defaultValue = "0")int page) {
        Page<Contract> entities = contractServices.getAll(PageRequest.of(page, 4));
        Page<ContractDto> contractDtos = entities.map(new Function<Contract, ContractDto>() {
            @Override
            public ContractDto apply(Contract contract) {
                ContractDto contractDto = new ContractDto();
                contractDto.setDateFinish(contract.getEndDate());
                contractDto.setDateStart(contract.getStartDate());
                contractDto.setDeposit(contract.getDeposit());
                contractDto.setId(contract.getId());
                contractDto.setNameCustomer(contract.getCustomer().getName());
                contractDto.setNameService(contract.getFacility().getName());
                contractDto.setRentingCost(contract.getFacility().getCost());
                return contractDto;
            }
        });
        model.addAttribute("contractList", contractDtos);
        return "contract/list";
    };
}

