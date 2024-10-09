package com.example.nullshinsaproduct.infrastructure.dto.response;

public record CheckOrdererResponse(
        boolean isOrderer,
        Long orderId,
        String orderSkuName
) {

    public boolean isNotOrderer() {
        return !this.isOrderer;
    }
}
