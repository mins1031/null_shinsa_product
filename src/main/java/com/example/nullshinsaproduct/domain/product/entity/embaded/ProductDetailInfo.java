package com.example.nullshinsaproduct.domain.product.entity.embaded;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDetailInfo {
    private String fabric;
    private String manufacturingCountry;
    private String washCaution;
    private String manufacturingDate;
    private String qualityGuarantee;
    private String detailContent;
    private String brandDetailContent;
    private String adminDetailContent;

    public ProductDetailInfo(
            String fabric,
            String manufacturingCountry,
            String washCaution,
            String manufacturingDate,
            String qualityGuarantee,
            String detailContent,
            String brandDetailContent,
            String adminDetailContent
    ) {
        this.fabric = fabric;
        this.manufacturingCountry = manufacturingCountry;
        this.washCaution = washCaution;
        this.manufacturingDate = manufacturingDate;
        this.qualityGuarantee = qualityGuarantee;
        this.detailContent = detailContent;
        this.brandDetailContent = brandDetailContent;
        this.adminDetailContent = adminDetailContent;
    }
}
