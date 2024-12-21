package com.example.nullshinsaproduct.product.application.dto.request;

import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;

public record SkuProductRequest (
        String name,
        int stock,
        int plusPrice,
        SkuProductStatus skuProductStatus
){
}
