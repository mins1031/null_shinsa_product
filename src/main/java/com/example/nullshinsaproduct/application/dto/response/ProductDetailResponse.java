package com.example.nullshinsaproduct.application.dto.response;

public record ProductDetailResponse(
        long id,
        long productId,
        String manufacturingCountry,
        String manufacturingCompany,
        String manufacturingDate,
        String qualityGuarantee,
        String fabric,
        String measurement,
        String washCaution,
        String productInnerItems,
        String asOfficerAndTel,
        String detailContent,
        String brandDetailContent,
        String adminDetailContent
) {
}
