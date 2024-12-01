package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import lombok.Getter;

@Getter
public class SkuProduct {

    private final long id;
    private final long productId;
    private final String name;
    private final int stock;
    private final int plusPrice;
    private final ProductStatus productStatus;

    public SkuProduct(long id, long productId, String name, int stock, int plusPrice, ProductStatus productStatus) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.stock = stock;
        this.plusPrice = plusPrice;
        this.productStatus = productStatus;
    }
}
