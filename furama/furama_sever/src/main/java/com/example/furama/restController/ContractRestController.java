package com.example.furama.restController;

import com.example.furama.dto.contractDTO.ContractDto;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.customer.Customer;
import com.example.furama.model.employee.Employee;
import com.example.furama.model.facility.Facility;
import com.example.furama.services.contract.IContractServices;
import com.example.furama.services.employee.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Converter;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/api/contractList")
public class ContractRestController {
    @Autowired
    IContractServices contractServices;
    @Autowired
    IEmployeeServices employeeServices;

    @GetMapping()
    public Page<Contract> getContract() {
        Page<Contract> entities = contractServices.getAll(PageRequest.of(0, 4));
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
                return contractDto;
            }
        });
        return entities;
    }

    //    public ContractDto mapContractToDto(Contract contract) {
//
//        return contractDto;
//    }
    @PostMapping("/save")
    public Long saveCustomer(@RequestBody ContractDto contractDto) {
        Contract contract = new Contract();
        contract.setDeposit(contractDto.getDeposit());
        contract.setEndDate(contractDto.getDateFinish());
        contract.setStartDate(contractDto.getDateStart());
        contract.setCustomer(new Customer(contractDto.getIdCustomer()));
        contract.setFacility(new Facility(contractDto.getIdService()));
        contract.setEmployee(employeeServices.getEmployeeById(2));
        contractServices.save(contract);

        return contract.getId();

    }
}
