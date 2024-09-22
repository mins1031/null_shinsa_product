package com.example.nullshinsaproduct.domain.dto.response;

import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;

import java.util.List;


public record ProductQueryResponse(
        Long productId,
        String name,
        int price,
        String fabric,
        String manufacturingCountry,
        String washCaution,
        String manufacturingDate,
        String qualityGuarantee,
        CouponApplyPossible couponApplyPossible,
        BrandResponse brandResponse,
        List<ProductSizeVo> productSizeVoList) {
}
