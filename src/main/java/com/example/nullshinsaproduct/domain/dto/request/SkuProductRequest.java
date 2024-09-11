package com.example.nullshinsaproduct.domain.dto.request;

import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;

public record SkuProductRequest (
        String color,
        String size,
        int stock,
        int discountRate,
        ProductStatus productStatus
){
}
