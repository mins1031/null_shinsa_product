package com.example.nullshinsaproduct.product.application.input.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;

import java.time.LocalDateTime;

public record ProductSizeResponse(
        Long id,
        Long productId,
        String sizeName,
        String totalLength,
        String shoulder,
        String chest,
        String sleeve,
        String waist,
        String crotch,
        String hip,
        String thigh,
        String hem,
        String width,
        String height,
        String depth,
        ProductSizeType productSizeType,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
