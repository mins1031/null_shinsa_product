package com.example.nullshinsaproduct.regacy.application.dto.response;

public record ProductOptionStockResponse(
        long productOptionId,
        int remainingStock,
        boolean isSoldOut
){
}
