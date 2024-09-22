package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.enumeration.ProductSizeType;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductTopSize extends ProductSize {
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;

    public ProductTopSize(
            String sizeName,
            Product product,
            ProductSizeType productSizeType,
            String length,
            String shoulder,
            String chest,
            String sleeve
    ) {
        super(sizeName, product, productSizeType);
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
    }

    @Override
    public String toString() {
        return "ProductTopSize{" +
                "length='" + length + '\'' +
                ", shoulder='" + shoulder + '\'' +
                ", chest='" + chest + '\'' +
                ", sleeve='" + sleeve + '\'' +
                '}';
    }
}
