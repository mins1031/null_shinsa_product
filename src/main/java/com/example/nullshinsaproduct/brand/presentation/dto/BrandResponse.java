package com.example.nullshinsaproduct.brand.presentation.dto;

public record BrandResponse(
        long brandId,
        String brandName,
        String oneLineIntroduce,
        String corporateNumber,
        String communicationSellingNumber,
        String representative,
        String location,
        String titleImageUrl,
        String introImageUrl
) {
}
