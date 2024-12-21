package com.example.nullshinsaproduct.product.application.event;


import java.util.List;

public record ProductSaveEvent (
        Long productId,
        String productName,
        String brandName,
        List<String> receiverEmail
) {

    public static ProductSaveEvent of(
            Long productId,
            String productName,
            String brandName,
            List<String> receiverEmail
    ) {
        return new ProductSaveEvent(
                productId,
                productName,
                brandName,
                receiverEmail
        );
    }
}
