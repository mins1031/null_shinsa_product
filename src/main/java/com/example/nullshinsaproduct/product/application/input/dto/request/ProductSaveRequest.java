package com.example.nullshinsaproduct.product.application.input.dto.request;

import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public record ProductSaveRequest (
    @NotBlank(message = "상품생성시 상품명은 필수 입니다.") String name,
    @Min(value = 0, message = "상품생성시 브랜드정보는 필수 입니다.") long brandId,
    @Min(value = 0, message = "상품생성시 가격정보는 필수 입니다.") int price,
    @NotNull(message = "상품생성시 카테고리 정보는 필수 입니다") CategoryInfoRequest categoryInfoRequest,
    CouponApplyPossible couponApplyPossible,
    DiscountApplyPossible discountApplyPossible,
    int discountMinRate,
    int discountMaxRate,
    int outboundPossibleDay,
    boolean isDeliveryFree,
    List<ProductSizeRequest> productSizeRequests,
    String thumbnailLink,
    List<String> profileImagesLink,
    List<String> detailImageLink,
    List<SkuProductRequest> skuProductRequests,
    @NotNull ProductType productType
) {
}
