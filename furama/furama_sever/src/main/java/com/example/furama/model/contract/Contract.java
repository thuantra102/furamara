package com.example.furama.model.contract;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.employee.Employee;
import com.example.furama.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Long id;
    @Column(name = "ngay_lam_hop_dong")
    private Date startDate;
    @Column(name = "ngay_ket_thuc")
    private Date endDate;
    @Column(name = "tien_dat_coc")
    private Float deposit;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "contract")
//    private List<ContractDetail> contractDetails;
//

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private Customer customer;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ma_dich_vu")
    private Facility facility;

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

//    public List<ContractDetail> getContractDetails() {
//        return contractDetails;
//    }
//
//    public void setContractDetails(List<ContractDetail> contractDetails) {
//        this.contractDetails = contractDetails;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contract() {
    }

    public Contract(Long id) {
        this.id = id;
    }
}
