package com.example.nullshinsaproduct.product.infrastructure.db.repository.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class FindSkuWithProductDto {
    private long productId;
    private long skuId;
    private String productName;
    private String skuName;
    private int productOriginPrice;
    private int skuPlusPrice;

    @QueryProjection
    public FindSkuWithProductDto(long productId, long skuId, String productName, String skuName, int productOriginPrice, int skuPlusPrice) {
        this.productId = productId;
        this.skuId = skuId;
        this.productName = productName;
        this.skuName = skuName;
        this.productOriginPrice = productOriginPrice;
        this.skuPlusPrice = skuPlusPrice;
    }
}
