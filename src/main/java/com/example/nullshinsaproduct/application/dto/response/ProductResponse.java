package com.example.nullshinsaproduct.application.dto.response;

import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;

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
