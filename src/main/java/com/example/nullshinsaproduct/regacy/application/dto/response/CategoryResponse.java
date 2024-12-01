package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.ThirdLayerCategory;

public record CategoryResponse(
        FirstLayerCategory firstLayerCategory,
        SecondLayerCategory secondLayerCategory,
        ThirdLayerCategory thirdLayerCategory,
        InferiorLayerCategory inferiorLayerCategory
) {
}
