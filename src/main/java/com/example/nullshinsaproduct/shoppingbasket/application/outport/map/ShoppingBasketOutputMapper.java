package com.example.nullshinsaproduct.shoppingbasket.application.outport.map;

import com.example.nullshinsaproduct.shoppingbasket.domain.ShoppingBasket;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;

public class ShoppingBasketOutputMapper {
    public static ShoppingBasketEntity toEntityFromDomain(final ShoppingBasket shoppingBasket) {
        return ShoppingBasketEntity.of(
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
}
