package com.example.nullshinsaproduct.review.application.output.dto;

public record CheckOrdererResponse(
        boolean isOrderer,
        Long orderId,
        Long ordererId,
        String orderProductName
) {

    public boolean isNotOrderer() {
        return !this.isOrderer;
    }
}
