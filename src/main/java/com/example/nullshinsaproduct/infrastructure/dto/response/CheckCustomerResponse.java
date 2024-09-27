package com.example.nullshinsaproduct.infrastructure.dto.response;

public record CheckCustomerResponse(
        boolean isCustomer,
        String orderSkuName
) {
}
