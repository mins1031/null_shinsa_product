package com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request;

public record ShoppingBasketUpdateRequest(
        long basketId,
        long productId,
        long skuId,
        String skuName,
        int skuCount
) {

    public boolean isNotExistSkuValue() {
        return this.skuId() == 0 || this.skuCount() == 0;
    }
}
