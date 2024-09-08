package com.example.nullshinsaproduct.domain.product.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductTopSize extends ProductSizeDetail {
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;

    public ProductTopSize(
            String sizeName,
            Product product,
            String length,
            String shoulder,
            String chest,
            String sleeve
    ) {
        super(sizeName, product);
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
    }
}
