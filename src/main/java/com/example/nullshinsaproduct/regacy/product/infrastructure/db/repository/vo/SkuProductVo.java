package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public record SkuProductVo(
        Long id,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        String color,
        String size,
        int stock,
        double startPoint,
        int discountRate,
        ProductStatus productStatus,
        Product product
) {
    // Root Entity(Product)에서 생성하는 메서드
//    public static SkuProductVo from(SkuProductEntity skuProductEntity) {
//        return new SkuProductVo(
//                skuProductEntity.getId(),
//                skuProductEntity.getCreatedDate(),
//                skuProductEntity.getUpdatedDate(),
//                skuProductEntity.getColor(),
//                skuProductEntity.getSize(),
//                skuProductEntity.getStock(),
//                skuProductEntity.getStartPoint(),
//                skuProductEntity.getDiscountRate(),
//                skuProductEntity.getProductStatus(),
//                null
//        );
//    }
//
//    // ProductImageVo 단독으로 조회시 생성하는 메서드
//    public static SkuProductVo of(SkuProductEntity skuProductEntity, Product product) {
//        return new SkuProductVo(
//                skuProductEntity.getId(),
//                skuProductEntity.getCreatedDate(),
//                skuProductEntity.getUpdatedDate(),
//                skuProductEntity.getColor(),
//                skuProductEntity.getSize(),
//                skuProductEntity.getStock(),
//                skuProductEntity.getStartPoint(),
//                skuProductEntity.getDiscountRate(),
//                skuProductEntity.getProductStatus(),
//                skuProductEntity.getProduct()
//        );
//    }

    public long getProductId() {
        if (Objects.isNull(this.product)) {
            return 0;
        }

        return this.product.getId();
    }
}
