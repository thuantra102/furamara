package com.example.furama.dto.contractDTO;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Map;

public class ContractDto {
    private Long id;
    private Long idService;
    private String nameService;
    private Long idCustomer;
    private String nameCustomer;
    private Date dateStart;
    private Date dateFinish;
    private Float deposit;
    private Float rentingCost;

    public ContractDto() {
    }

    public ContractDto(Long id, Long idService, String nameService, Long idCustomer, String nameCustomer, Date dateStart, Date dateFinish, Float deposit, Float rentingCost) {
        this.id = id;
        this.idService = idService;
        this.nameService = nameService;
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.deposit = deposit;
        this.rentingCost = rentingCost;

    }

    public ContractDto(Long id, Long idService, Long idCustomer, Date dateStart, Date dateFinish, Float deposit) {
        this.id = id;
        this.idService = idService;
        this.idCustomer = idCustomer;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.deposit = deposit;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }


    public Float getRentingCost() {
        return rentingCost;
    }

    public void setRentingCost(Float rentingCost) {
        this.rentingCost = rentingCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }
}
