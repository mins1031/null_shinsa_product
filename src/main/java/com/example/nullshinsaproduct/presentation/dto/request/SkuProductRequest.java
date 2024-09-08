package com.example.nullshinsaproduct.presentation.dto.request;

import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;

public record SkuProductRequest (
        long productId,
        String color,
        String size,
        int stock,
        int discountRate,
        ProductStatus productStatus
){
}
