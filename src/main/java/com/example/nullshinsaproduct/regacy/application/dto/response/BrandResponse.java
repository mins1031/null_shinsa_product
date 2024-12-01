package com.example.nullshinsaproduct.regacy.application.dto.response;

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
