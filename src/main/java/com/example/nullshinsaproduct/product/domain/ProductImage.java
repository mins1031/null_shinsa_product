package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ProductImage {

    private Long id;
    private Long productId;
    private String imageUrl;
    private ImageType imageType;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private ProductImage(
            Long id,
            Long productId,
            String imageUrl,
            ImageType imageType,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        this.id = id;
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public static ProductImage of(
            Long id,
            long productId,
            String imageUrl,
            ImageType imageType
    ) {
        return new ProductImage(id, productId, imageUrl, imageType, LocalDateTime.now(), LocalDateTime.now());
    }

    public static ProductImage createDefault(long productId, String imageUrl, ImageType imageType) {
        return new ProductImage(null, productId, imageUrl, imageType, LocalDateTime.now(), LocalDateTime.now());
    }
}
