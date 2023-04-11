package com.example.furama.model.employee;

import com.example.furama.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer id;
    @Column(name = "ho_va_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private Date dateOfBirth;
    @Column (name = "so_cmnd")
    private String  identityCard;
    @Column (name = "luong")
    private Double salary;
    @Column (name = "so_dien_thoai")
    private String phoneNumber;
    @Column (name = "email")
    private String email;
    @Column (name = "dia_chi")
    private String address;
    @ManyToOne
    @JoinColumn(name = "ma_vi_tri")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "ma_trinh_do")
    private Level level;
    @ManyToOne
    @JoinColumn(name = "ma_bo_phan")
    private Department department;

//    @JsonBackReference
//    @OneToMany(mappedBy = "employee")
//    private List<Contract> contracts;

//    public List<Contract> getContracts() {
//        return contracts;
//    }
//
//    public void setContracts(List<Contract> contracts) {
//        this.contracts = contracts;
//    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public  Position getPosition(){
        return  this.position;
    }
    public  void setPosition(Position position){
        this.position= position;
    }
    public  Employee(){

    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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
}
