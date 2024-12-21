package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.brand.presentation.dto.BrandResponse;

import java.util.List;


public record ProductQueryResponse(
        ProductResponse productResponse,
        ProductDetailResponse productDetailRes,
        CategoryResponse categoryRes,
        BrandResponse brandResponse,
        List<SkuProductResponse> skuProductResList,
        List<ProductSizeResponse> sizeResList,
        List<ProductImageResponse> productImageResList
) {
}
