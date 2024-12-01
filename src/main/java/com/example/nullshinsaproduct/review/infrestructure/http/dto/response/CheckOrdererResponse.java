package com.example.nullshinsaproduct.review.infrestructure.http.dto.response;

public record CheckOrdererResponse(
        boolean isOrderer,
        Long orderId,
        String orderSkuName
) {

    public boolean isNotOrderer() {
        return !this.isOrderer;
    }
}
