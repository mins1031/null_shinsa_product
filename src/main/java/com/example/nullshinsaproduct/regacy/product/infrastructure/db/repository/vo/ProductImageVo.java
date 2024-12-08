package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;

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
    public static ProductImageVo from(ProductImageEntity productImageEntity) {
        return new ProductImageVo(
                productImageEntity.getId(),
                productImageEntity.getCreatedDate(),
                productImageEntity.getUpdatedDate(),
                productImageEntity.getImageUrl(),
                productImageEntity.getImageType(),
                null
        );
    }

    // ProductImageVo 단독으로 조회시 생성하는 메서드
    public static ProductImageVo of(ProductImageEntity productImageEntity, Product product) {
        return new ProductImageVo(
                productImageEntity.getId(),
                productImageEntity.getCreatedDate(),
                productImageEntity.getUpdatedDate(),
                productImageEntity.getImageUrl(),
                productImageEntity.getImageType(),
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
