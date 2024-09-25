package com.example.nullshinsaproduct.infrastructure.repository.vo;

import com.example.nullshinsaproduct.domain.product.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.domain.product.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.ThirdLayerCategory;

public record CategoryVo (
        FirstLayerCategory firstLayerCategory,
        SecondLayerCategory secondLayerCategory,
        ThirdLayerCategory thirdLayerCategory,
        InferiorLayerCategory inferiorLayerCategory
) {

    public static CategoryVo from(CategoryInfo categoryInfo) {
        return new CategoryVo(
                categoryInfo.getFirstLayerCategory(),
                categoryInfo.getSecondLayerCategory(),
                categoryInfo.getThirdLayerCategory(),
                categoryInfo.getInferiorLayerCategory()
        );
    }
}
