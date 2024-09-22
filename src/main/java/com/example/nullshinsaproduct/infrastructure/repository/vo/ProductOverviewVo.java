package com.example.nullshinsaproduct.infrastructure.repository.vo;

import com.example.nullshinsaproduct.domain.dto.response.ProductSizeVo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;

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
