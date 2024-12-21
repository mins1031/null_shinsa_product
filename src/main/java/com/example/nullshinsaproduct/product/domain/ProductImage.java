package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import lombok.Getter;


@Getter
public class ProductImage {

    private Long id;
    private long productId;
    private String imageUrl;
    private ImageType imageType;

    private ProductImage(Long id, long productId, String imageUrl, ImageType imageType) {
        this.id = id;
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
    }

    public static ProductImage of(
            Long id,
            long productId,
            String imageUrl,
            ImageType imageType
    ) {
        return new ProductImage(id, productId, imageUrl, imageType);
    }

    public static ProductImage createDefault(long productId, String imageUrl, ImageType imageType) {
        return new ProductImage(null, productId, imageUrl, imageType);
    }
}
