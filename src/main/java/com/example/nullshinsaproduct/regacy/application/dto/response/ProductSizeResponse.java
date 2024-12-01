package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;

import java.time.LocalDateTime;

public record ProductSizeResponse(
        long sizeId,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        String sizeName,
        ProductSizeType productSizeType,
        String length,
        String shoulder,
        String chest,
        String sleeve,
        String waist,
        String crotch,
        String hip,
        String thigh,
        String hem,
        long productId
) {
}
