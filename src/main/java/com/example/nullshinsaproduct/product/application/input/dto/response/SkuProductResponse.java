package com.example.nullshinsaproduct.product.application.input.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;

import java.time.LocalDateTime;

public record SkuProductResponse(
        Long id,
        Long productId,
        String name,
        int stock,
        double plusPrice,
        SkuProductStatus skuProductStatus,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
