package com.example.nullshinsaproduct.product.application.input.dto.request;


import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;

public record ProductSizeRequest (
        String sizeName,
        String totalLength,
        String shoulder, // 어깨너비
        String chest, // 가슴단면
        String sleeve, // 소매길이
        String waist, // 허리
        String crotch, // 밑위
        String hip, // 엉덩이 단면
        String thigh, // 허벅지 단면
        String hem, // 밑단
        String width, // 너비
        String height, // 높이
        String depth, // 폭(깊이)
        ProductSizeType productSizeType
) {
}
