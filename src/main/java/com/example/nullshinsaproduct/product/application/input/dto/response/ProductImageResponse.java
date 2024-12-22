package com.example.nullshinsaproduct.product.application.input.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;

import java.time.LocalDateTime;

public record ProductImageResponse(
        Long id,
        Long productId,
        String imageUrl,
        ImageType imageType,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
