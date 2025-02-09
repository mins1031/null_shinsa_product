package com.example.nullshinsaproduct.shoppingbasket.application.outport.map;

import com.example.nullshinsaproduct.shoppingbasket.domain.ShoppingBasket;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;

public class ShoppingBasketOutputMapper {
    public static ShoppingBasketEntity toEntityFromDomain(final ShoppingBasket shoppingBasket) {
        return ShoppingBasketEntity.of(
                shoppingBasket.getBasketId(),
                shoppingBasket.getProductId(),
                shoppingBasket.getSkuId(),
                shoppingBasket.getCustomerId(),
                shoppingBasket.getBrandId(),
                shoppingBasket.getBrandName(),
                shoppingBasket.getProductName(),
                shoppingBasket.getSkuName(),
                shoppingBasket.getSkuCount(),
                shoppingBasket.getProductPrice(),
                shoppingBasket.getDiscountPriceWhenSave()
        );
    }

    public static ShoppingBasket toDomainFromEntity(final ShoppingBasketEntity entity) {
        return ShoppingBasket.of(
                entity.getId(),
                entity.getProductId(),
                entity.getSkuId(),
                entity.getCustomerId(),
                entity.getBrandId(),
                entity.getBrandName(),
                entity.getProductName(),
                entity.getSkuName(),
                entity.getSkuCount(),
                entity.getProductPrice(),
                entity.getDiscountPriceWhenSave()
        );
    }
}
