package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductClothesOption extends BaseEntity {

    private String color;
    private String size;
    private ProductClothesTopOption productClothesTopOption;
    private ProductClothesBottomOption productClothesBottomOption;
    private int stock;

    @Column(nullable = false)
    private Long productId;

    public ProductClothesOption(String size,
                                String color,
                                ProductClothesTopOption productClothesTopOption,
                                ProductClothesBottomOption productClothesBottomOption,
                                int stock,
                                Long productId
    ) {
        this.color = color;
        this.size = size;
        this.productClothesTopOption = productClothesTopOption;
        this.productClothesBottomOption = productClothesBottomOption;
        this.stock = stock;
        this.productId = productId;
    }

    public boolean isSoldOut() {
        return this.stock == 0;
    }
}
