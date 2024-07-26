
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
public class ProductClothesBottomOption {
    private String waist;
    private String crotch;
    private String hip;
    private String thigh;
    private String hem;

    public ProductClothesBottomOption(String waist, String crotch, String hip, String thigh, String hem) {
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
    }
}
