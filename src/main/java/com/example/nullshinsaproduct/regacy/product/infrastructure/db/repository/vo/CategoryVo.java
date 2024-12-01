package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.regacy.product.domain.enumeration.category.ThirdLayerCategory;

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
