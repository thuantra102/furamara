package com.example.furama.dto.contractDTO;

public class FacilityDTO {
    private Long id;
    private String name;
    private Float cost;

    public FacilityDTO() {
    }

    public FacilityDTO(Long id, String name, Float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
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
}
