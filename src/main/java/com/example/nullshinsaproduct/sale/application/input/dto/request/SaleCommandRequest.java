package com.example.nullshinsaproduct.sale.application.input.dto.request;


import java.time.LocalDateTime;

public record SaleCommandRequest(
        String name,
        int salePercent,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime
) {
}
