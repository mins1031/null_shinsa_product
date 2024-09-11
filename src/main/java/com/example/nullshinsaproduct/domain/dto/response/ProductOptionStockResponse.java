package com.example.nullshinsaproduct.domain.dto.response;

public record ProductOptionStockResponse(
        long productOptionId,
        int remainingStock,
        boolean isSoldOut
){
}
