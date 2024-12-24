package com.example.nullshinsaproduct.product.application.input.dto.response;

import com.example.nullshinsaproduct.brand.apllication.dto.BrandResponse;
import java.util.List;

public record ProductQueryResponse (
        ProductResponse productResponse,
        CategoryResponse categoryResponse,
        BrandResponse brandResponse,
        List<SkuProductResponse> skuProductResList,
        List<ProductSizeResponse> sizeResList,
        List<ProductImageResponse> productImageResList
) {
}
