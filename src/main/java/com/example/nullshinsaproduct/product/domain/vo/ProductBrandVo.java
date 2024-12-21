package com.example.nullshinsaproduct.product.domain.vo;

import lombok.Getter;

@Getter
public class ProductBrandVo {
    private final Long brandId;
    private final String brandName;
    private final String corporateNumber;
    private final String communicationSellingNumber;
    private final String representative;
    private final String location;

    public ProductBrandVo(
            Long brandId,
            String brandName,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location
    ) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.corporateNumber = corporateNumber;
        this.communicationSellingNumber = communicationSellingNumber;
        this.representative = representative;
        this.location = location;
    }

    public static ProductBrandVo of(
            Long brandId,
            String brandName,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location
    ) {
        return new ProductBrandVo(
                brandId,
                brandName,
                corporateNumber,
                communicationSellingNumber,
                representative,
                location
        );
    }
}
