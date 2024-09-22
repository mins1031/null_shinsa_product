package com.example.nullshinsaproduct.application.dto.response;

import com.example.nullshinsaproduct.domain.product.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.ThirdLayerCategory;

public record CategoryResponse(
        FirstLayerCategory firstLayerCategory,
        SecondLayerCategory secondLayerCategory,
        ThirdLayerCategory thirdLayerCategory,
        InferiorLayerCategory inferiorLayerCategory
) {
}
