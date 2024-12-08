package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import lombok.Getter;

@Getter
public class SkuProduct {
    private final long id;
    private final long parentProductId;
    private final String name;
    private final int stock;
    private final int plusPrice;
    private final SkuProductStatus productStatus;

    public SkuProduct(long id, long parentProductId, String name, int stock, int plusPrice, SkuProductStatus productStatus) {
        this.id = id;
        this.parentProductId = parentProductId;
        this.name = name;
        this.stock = stock;
        this.plusPrice = plusPrice;
        this.productStatus = productStatus;
    }
}
