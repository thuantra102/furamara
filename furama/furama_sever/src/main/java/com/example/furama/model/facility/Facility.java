package com.example.furama.model.facility;

import com.example.furama.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "dich_vu")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private  Long id;
    @Column(name = "ten_dich_vu")
    private String name;
    @Column(name = "dien_tich")
    private Integer area;
    @Column(name = "chi_phi_thue")
    private Float cost;
    @Column(name = "so_nguoi_toi_da")
    private Integer maxPeople;
    @Column(name = "tieu_chuan_phong")
    private String standardRoom;
    @Column(name = "mo_ta_tien_nghi_khac")
    private String descriptionOtherConvenience;
    @Column(name = "dien_tich_ho_boi")
    private Double poolArea;
    @Column(name = "so_tang")
    private Integer numberOfFloors;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue")
    private RentType rentType;
@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu")
    private FacilityType facilityType;

    @JsonBackReference
    @OneToMany(mappedBy = "facility")
    private List<Contract> contractList;


    public Facility() {
    }

    public Facility(Long id) {
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }
}
