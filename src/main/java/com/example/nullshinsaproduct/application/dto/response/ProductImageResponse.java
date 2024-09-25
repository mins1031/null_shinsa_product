package com.example.nullshinsaproduct.application.dto.response;

import com.example.nullshinsaproduct.domain.product.enumeration.ImageType;

import java.time.LocalDateTime;

public record ProductImageResponse(
        long id,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        String imageUrl,
        ImageType imageType,
        long productId
) {
}
