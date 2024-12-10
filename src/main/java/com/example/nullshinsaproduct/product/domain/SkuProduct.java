package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SkuProduct {
    private Long id;
    private long parentProductId;
    private String name;
    private int stock;
    private int plusPrice;
    private SkuProductStatus productStatus;

    public SkuProduct(Long id, long parentProductId, String name, int stock, int plusPrice, SkuProductStatus productStatus) {
        this.id = id;
        this.parentProductId = parentProductId;
        this.name = name;
        this.stock = stock;
        this.plusPrice = plusPrice;
        this.productStatus = productStatus;
    }

    public static SkuProduct createDefault(
            long parentProductId,
            String name,
            int stock,
            int plusPrice,
            SkuProductStatus skuProductStatus
    ) {
        return new SkuProduct(
                null,
                parentProductId,
                name,
                stock,
                plusPrice,
                skuProductStatus
        );
    }
}
