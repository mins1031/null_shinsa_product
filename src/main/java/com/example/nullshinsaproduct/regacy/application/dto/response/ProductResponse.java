package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;

import java.time.LocalDateTime;

public record ProductResponse(
        Long productId,
        String name,
        int price,
        int outboundPossibleDay,
        DeliveryFee deliveryFee,
        CouponApplyPossible couponApplyPossible,
        DiscountApplyPossible discountApplyPossible,
        int discountMinRate,
        int discountMaxRate,
        ProductType productType,
        LocalDateTime productCreatedDate,
        LocalDateTime productUpdatedDate
) {
}
