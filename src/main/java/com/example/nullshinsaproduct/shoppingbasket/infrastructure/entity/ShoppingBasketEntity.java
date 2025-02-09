package com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(
        name = "shopping_basket"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoppingBasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private long productId;
    private long skuId;
    private long customerId;
    private long brandId;
    private String brandName;
    private String productName;
    private String skuName;
    private int skuCount;
    private int productPrice;
    private int discountPriceWhenSave;

    private ShoppingBasketEntity(Long id, long productId, long skuId, long customerId, long brandId, String brandName, String productName, String skuName, int skuCount, int productPrice, int discountPriceWhenSave) {
        this.id = id;
        this.productId = productId;
        this.skuId = skuId;
        this.customerId = customerId;
        this.brandId = brandId;
        this.brandName = brandName;
        this.productName = productName;
        this.skuName = skuName;
        this.skuCount = skuCount;
        this.productPrice = productPrice;
        this.discountPriceWhenSave = discountPriceWhenSave;
    }

    public static ShoppingBasketEntity of(
            Long id,
            long productId,
            long skuId,
            long customerId,
            long brandId,
            String brandName,
            String productName,
            String skuName,
            int skuCount,
            int productPrice,
            int discountPriceWhenSave
    ) {
        return new ShoppingBasketEntity(
                id,
                productId,
                skuId,
                customerId,
                brandId,
                brandName,
                productName,
                skuName,
                skuCount,
                productPrice,
                discountPriceWhenSave
        );
    }

//    public void update(long skuId, int skuCount) {
//        this.
//    }
}
