package com.example.nullshinsaproduct.product.infrastructure.db.repository.dto;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class FindSkuWithProductDto {
    private long productId;
    private long skuId;
    private String productName;
    private String skuName;
    private int productOriginPrice;
    private int skuPlusPrice;
    private ProductStatus productStatus;
    private SkuProductStatus skuProductStatus;

    @QueryProjection
    public FindSkuWithProductDto(long productId, long skuId, String productName, String skuName, int productOriginPrice, int skuPlusPrice, ProductStatus productStatus, SkuProductStatus skuProductStatus) {
        this.productId = productId;
        this.skuId = skuId;
        this.productName = productName;
        this.skuName = skuName;
        this.productOriginPrice = productOriginPrice;
        this.skuPlusPrice = skuPlusPrice;
        this.productStatus = productStatus;
        this.skuProductStatus = skuProductStatus;
    }
}
