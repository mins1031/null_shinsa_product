package com.example.nullshinsaproduct.application.dto.response;

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
