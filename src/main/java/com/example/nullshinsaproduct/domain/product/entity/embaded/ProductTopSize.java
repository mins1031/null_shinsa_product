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
public class ProductTopSize extends ProductSizeDetail {
    private String sizeName;
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;

    public ProductTopSize(String sizeName, String length, String shoulder, String chest, String sleeve) {
        this.sizeName = sizeName;
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
    }
}
