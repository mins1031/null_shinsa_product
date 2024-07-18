package com.example.nullshinsaproduct.domain.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductDetailRequest {
    private String fabric;
    private String manufacturingCountry;
    private String washCaution;
    private String manufacturingDate;
    private String qualityGuarantee;

    public ProductDetailRequest(String fabric, String manufacturingCountry, String washCaution, String manufacturingDate, String qualityGuarantee) {
        this.fabric = fabric;
        this.manufacturingCountry = manufacturingCountry;
        this.washCaution = washCaution;
        this.manufacturingDate = manufacturingDate;
        this.qualityGuarantee = qualityGuarantee;
    }
}
