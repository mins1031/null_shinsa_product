package com.example.nullshinsaproduct.domain.dto.request;

public record ProductSizeRequest (
    String sizeName,
    String length,
    String shoulder,
    String chest,
    String sleeve,
    String waist,
    String crotch,
    String hip,
    String thigh,
    String hem
) {
}
