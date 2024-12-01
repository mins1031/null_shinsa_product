package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo;

import com.example.nullshinsaproduct.regacy.application.dto.response.ProductSizeVo;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.ProductType;

import java.time.LocalDateTime;
import java.util.List;

public record ProductOverviewVo(
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
        LocalDateTime productUpdatedDate,
        ProductDetailVo productDetailVo,
        CategoryVo categoryVo,
        List<SkuProductVo> skuProductVoList,
        List<ProductSizeVo> sizeVoList,
        List<ProductImageVo> productImageList
) {

}
