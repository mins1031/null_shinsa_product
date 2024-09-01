package com.example.nullshinsaproduct.presentation.dto.response;

public record ProductOptionStockResponse(
        long productOptionId,
        int remainingStock,
        boolean isSoldOut
){
}
