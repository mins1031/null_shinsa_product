package com.example.nullshinsaproduct.regacy.application.dto.request;

import com.example.nullshinsaproduct.regacy.product.domain.enumeration.ProductStatus;

public record SkuProductRequest (
        String color,
        String size,
        int stock,
        int discountRate,
        ProductStatus productStatus
){
}
