package com.example.nullshinsaproduct.domain.dto.response;

import com.example.nullshinsaproduct.domain.enumeration.CouponApplyPossible;
import lombok.Getter;
import lombok.ToString;

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
