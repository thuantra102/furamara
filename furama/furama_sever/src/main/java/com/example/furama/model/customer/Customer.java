package com.example.furama.model.customer;

import com.example.furama.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private Long id;
    @Pattern(regexp = "([A-Z][a-z]{0,}[ ]?)+", message = "wrong name")
    @Column(name = "ho_va_ten")
    private String name;

    //    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotNull(message = "Date field is must")
    @Column(name = "ngay_sinh")
    private Date dateOfBirth;

    @Column(name = "gioi_tinh")
    private Boolean gender;
    @Pattern(regexp = "[0-9]{9}", message = "Wrong Pattern Identification Number")
    @Column(name = "so_cmnd")
    private String identityCard;
    @Pattern(regexp = "0[0-9]{9}", message = "Phone Number have to correct the pattern")
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    @NotBlank(message = "email not empty")
    @Email(message = "Wrong pattern Email")
    @Column(name = "email")
    private String email;
    @NotBlank(message = "address not empty")
    @Column(name = "dia_chi")
    private String address;
    //    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ma_loai_khach")
    private CustomerType customerType;

//    @JsonBackReference
//    @OneToMany(mappedBy = "customer")
//    private List<Contract> contracts;
//
//
//    public List<Contract> getContracts() {
//        return contracts;
//    }
//
//    public void setContracts(List<Contract> contracts) {
//        this.contracts = contracts;
//    }

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
