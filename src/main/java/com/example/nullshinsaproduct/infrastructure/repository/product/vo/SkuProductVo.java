package com.example.nullshinsaproduct.infrastructure.repository.product.vo;

import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;

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
    public static SkuProductVo from(SkuProduct skuProduct) {
        return new SkuProductVo(
                skuProduct.getId(),
                skuProduct.getCreatedDate(),
                skuProduct.getUpdatedDate(),
                skuProduct.getColor(),
                skuProduct.getSize(),
                skuProduct.getStock(),
                skuProduct.getStartPoint(),
                skuProduct.getDiscountRate(),
                skuProduct.getProductStatus(),
                null
        );
    }

    // ProductImageVo 단독으로 조회시 생성하는 메서드
    public static SkuProductVo of(SkuProduct skuProduct, Product product) {
        return new SkuProductVo(
                skuProduct.getId(),
                skuProduct.getCreatedDate(),
                skuProduct.getUpdatedDate(),
                skuProduct.getColor(),
                skuProduct.getSize(),
                skuProduct.getStock(),
                skuProduct.getStartPoint(),
                skuProduct.getDiscountRate(),
                skuProduct.getProductStatus(),
                skuProduct.getProduct()
        );
    }

    public long getProductId() {
        if (Objects.isNull(this.product)) {
            return 0;
        }

        return this.product.getId();
    }
}
