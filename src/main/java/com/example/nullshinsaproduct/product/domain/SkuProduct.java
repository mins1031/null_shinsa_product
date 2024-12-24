package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class SkuProduct {
    private Long id;
    private Long parentProductId;
    private String name;
    private int stock;
    private int plusPrice;
    private SkuProductStatus skuProductStatus;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    public SkuProduct(
            Long id,
            Long parentProductId,
            String name,
            int stock,
            int plusPrice,
            SkuProductStatus skuProductStatus,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        this.id = id;
        this.parentProductId = parentProductId;
        this.name = name;
        this.stock = stock;
        this.plusPrice = plusPrice;
        this.skuProductStatus = skuProductStatus;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public static SkuProduct of(
            Long id,
            Long parentProductId,
            String name,
            int stock,
            int plusPrice,
            SkuProductStatus skuProductStatus
    ) {
        return new SkuProduct(
                id,
                parentProductId,
                name,
                stock,
                plusPrice,
                skuProductStatus,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public static SkuProduct createDefault(
            Long parentProductId,
            String name,
            int stock,
            int plusPrice,
            SkuProductStatus skuProductStatus
    ) {
        return new SkuProduct(
                null,
                parentProductId,
                name,
                stock,
                plusPrice,
                skuProductStatus,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
