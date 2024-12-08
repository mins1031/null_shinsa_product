package com.example.nullshinsaproduct.product.application.dto.request;

import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;

public record CategoryInfoRequest (
        FirstLayerCategory firstLayerCategory,
        SecondLayerCategory secondLayerCategory,
        ThirdLayerCategory thirdLayerCategory,
        InferiorLayerCategory inferiorLayerCategory
) { }
