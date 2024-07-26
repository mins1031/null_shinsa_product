package com.example.nullshinsaproduct.domain.product.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductClothesTopOption {
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;

    public ProductClothesTopOption(String length, String shoulder, String chest, String sleeve) {
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
    }
}
