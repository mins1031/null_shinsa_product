package com.example.nullshinsaproduct.review.infrestructure.http.dto.response;

public record CheckOrdererInfraResponse(
        boolean isOrderer,
        Long orderId,
        Long ordererId,
        String orderedProductName
) {

}
