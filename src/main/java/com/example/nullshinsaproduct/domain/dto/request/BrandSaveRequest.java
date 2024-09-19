package com.example.nullshinsaproduct.domain.dto.request;

public record BrandSaveRequest(
        String brandName,
        String corporateNumber,
        String communicationSellingNumber,
        String representative,
        String location
) {
}
