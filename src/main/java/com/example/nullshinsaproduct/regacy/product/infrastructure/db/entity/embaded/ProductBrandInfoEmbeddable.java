package com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductBrandInfoEmbeddable {
    private Long brandId;
    private String brandName;
    private String corporateNumber;
    private String communicationSellingNumber;
    private String representative;
    private String location;

    public ProductBrandInfoEmbeddable(Long brandId, String brandName, String corporateNumber, String communicationSellingNumber, String representative, String location) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.corporateNumber = corporateNumber;
        this.communicationSellingNumber = communicationSellingNumber;
        this.representative = representative;
        this.location = location;
    }
}
