package com.example.nullshinsaproduct.application.dto.response;

import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;

import java.time.LocalDateTime;

public record SkuProductResponse(
        long id,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        String color,
        String size,
        int stock,
        double startPoint,
        int discountRate,
        ProductStatus productStatus,
        long productId
) {
}
