package com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request;

public record ShoppingBasketSaveRequest(
        long productId,
        long skuId,
        long customerId,
        long brandId,
        String brandName,
        String productName,
        String skuName,
        int skuCount,
        int presentDiscountPricePerSku
) {
}
