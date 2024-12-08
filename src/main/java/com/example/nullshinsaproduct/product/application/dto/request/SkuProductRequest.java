package com.example.nullshinsaproduct.product.application.dto.request;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;

public record SkuProductRequest (
        String name,
        int stock,
        ProductStatus productStatus
){
}
