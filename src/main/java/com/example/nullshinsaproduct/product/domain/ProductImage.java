package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductImage {

    private final long id;
    private final long productId;
    private final String imageUrl;
    private final ImageType imageType;

    private ProductImage(long id, long productId, String imageUrl, ImageType imageType) {
        this.id = id;
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }

    public static ProductImage of(long id, long productId, String imageUrl, ImageType imageType) {
        return new ProductImage(id, productId, imageUrl, imageType);
    }
}
