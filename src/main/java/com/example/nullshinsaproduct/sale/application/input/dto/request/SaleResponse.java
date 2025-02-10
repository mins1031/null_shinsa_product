package com.example.nullshinsaproduct.sale.application.input.dto.request;

import com.example.nullshinsaproduct.sale.domain.SaleStatus;

import java.time.LocalDateTime;

public record SaleResponse(
        long saleId,
        String name,
        int salePercent,
        SaleStatus saleStatus,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime
) {
}
