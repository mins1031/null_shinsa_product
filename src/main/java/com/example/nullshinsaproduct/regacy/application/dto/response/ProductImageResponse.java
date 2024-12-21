package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;

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
