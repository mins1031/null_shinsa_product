package com.example.nullshinsaproduct.product.domain.vo;

import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;

public record ProductSaveVo(
        String name,
        int price,
        FirstLayerCategory firstLayerCategory,
        SecondLayerCategory secondLayerCategory,
        ThirdLayerCategory thirdLayerCategory,
        CouponApplyPossible couponApplyPossible,
        DiscountApplyPossible discountApplyPossible,
        int discountMinRate,
        int discountMaxRate,
        int outboundPossibleDay,
        boolean isDeliveryFree,
        ProductType productType
) {
}
