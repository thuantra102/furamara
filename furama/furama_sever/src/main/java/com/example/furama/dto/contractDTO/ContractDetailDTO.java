package com.example.furama.dto.contractDTO;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class ContractDetailDTO {
    private Long id;
    private Long idContract;
    private Long idAttachFacility;
    private Integer quality;

    public ContractDetailDTO() {
    }

    public ContractDetailDTO(Long id, Long idContract, Long idAttachFacility, Integer quality) {
        this.id = id;
        this.idContract = idContract;
        this.idAttachFacility = idAttachFacility;
        this.quality = quality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public Long getIdAttachFacility() {
        return idAttachFacility;
    }

    public void setIdAttachFacility(Long idAttachFacility) {
        this.idAttachFacility = idAttachFacility;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }
}
