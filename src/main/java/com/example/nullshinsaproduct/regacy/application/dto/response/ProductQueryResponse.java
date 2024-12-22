package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.brand.apllication.dto.BrandResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.CategoryResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductImageResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductSizeResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.SkuProductResponse;

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
