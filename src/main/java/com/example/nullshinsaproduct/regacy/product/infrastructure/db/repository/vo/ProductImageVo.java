package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductImage;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.ImageType;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProductImageVo(
        long id,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        String imageUrl,
        ImageType imageType,
        Product product
) {

    // Root Entity(Product)에서 생성하는 메서드
    public static ProductImageVo from(ProductImage productImage) {
        return new ProductImageVo(
                productImage.getId(),
                productImage.getCreatedDate(),
                productImage.getUpdatedDate(),
                productImage.getImageUrl(),
                productImage.getImageType(),
                null
        );
    }

    // ProductImageVo 단독으로 조회시 생성하는 메서드
    public static ProductImageVo of(ProductImage productImage, Product product) {
        return new ProductImageVo(
                productImage.getId(),
                productImage.getCreatedDate(),
                productImage.getUpdatedDate(),
                productImage.getImageUrl(),
                productImage.getImageType(),
                product
        );
    }

    public long getProductId() {
        if (Objects.isNull(this.product)) {
            return 0;
        }

        return this.product.getId();
    }
}
