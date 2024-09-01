package com.example.nullshinsaproduct.presentation.dto.response;

import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;

import java.util.List;

public record ProductResponse(
        Long productId,
        String name,
        int price,
        String fabric,
        String manufacturingCountry,
        String washCaution,
        String manufacturingDate,
        String qualityGuarantee,
        CouponApplyPossible couponApplyPossible,
        List<ProductOptionResponse> productOptionResponseList) {
}
