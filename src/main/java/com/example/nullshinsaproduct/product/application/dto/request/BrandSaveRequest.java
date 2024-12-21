package com.example.nullshinsaproduct.product.application.dto.request;

public record BrandSaveRequest(
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
