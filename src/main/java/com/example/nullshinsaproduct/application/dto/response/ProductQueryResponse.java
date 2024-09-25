package com.example.nullshinsaproduct.application.dto.response;

import com.example.nullshinsaproduct.infrastructure.repository.vo.CategoryVo;
import com.example.nullshinsaproduct.infrastructure.repository.vo.ProductDetailVo;
import com.example.nullshinsaproduct.infrastructure.repository.vo.ProductImageVo;
import com.example.nullshinsaproduct.infrastructure.repository.vo.SkuProductVo;

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
