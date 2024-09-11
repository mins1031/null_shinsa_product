
package com.example.nullshinsaproduct.domain.product.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductBottomSize extends ProductSize {
    private String length;
    private String waist;
    private String crotch;
    private String hip;
    private String thigh;
    private String hem;

    public ProductBottomSize(
            String sizeName,
            Product product,
            String length,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem
    ) {
        super(sizeName, product);
        this.length = length;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
    }
}
