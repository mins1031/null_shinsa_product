package com.example.nullshinsaproduct.application.dto.response;

public record ProductOptionStockResponse(
        long productOptionId,
        int remainingStock,
        boolean isSoldOut
){
}
