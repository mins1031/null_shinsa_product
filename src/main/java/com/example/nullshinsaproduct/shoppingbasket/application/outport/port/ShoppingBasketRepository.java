package com.example.nullshinsaproduct.shoppingbasket.application.outport.port;

import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;

public interface ShoppingBasketRepository {
    ShoppingBasketEntity saveShoppingBasket(ShoppingBasketEntity entity);
}
