package com.example.nullshinsaproduct.brand.domain;

import lombok.Getter;

@Getter
public class Brand {
    private final Long id;
    private String brandName;
    private String oneLineIntroduce;
    private String corporateNumber;
    private String communicationSellingNumber;
    private String representative;
    private String location;
    private String titleImageUrl;
    private String introImageUrl;

    private Brand(
            Long id,
            String brandName,
            String oneLineIntroduce,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location,
            String titleImageUrl,
            String introImageUrl
    ) {
        this.id = id;
        this.brandName = brandName;
        this.oneLineIntroduce = oneLineIntroduce;
        this.corporateNumber = corporateNumber;
        this.communicationSellingNumber = communicationSellingNumber;
        this.representative = representative;
        this.location = location;
        this.titleImageUrl = titleImageUrl;
        this.introImageUrl = introImageUrl;
    }

    public static Brand of(
            Long id,
            String brandName,
            String oneLineIntroduce,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location,
            String titleImageUrl,
            String introImageUrl
    ) {
        return new Brand(
                id,
                brandName,
                oneLineIntroduce,
                corporateNumber,
                communicationSellingNumber,
                representative,
                location,
                titleImageUrl,
                introImageUrl
        );
    }
}
