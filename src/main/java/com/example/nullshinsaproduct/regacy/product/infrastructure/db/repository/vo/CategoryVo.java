package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfoEntity;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;

public record CategoryVo (
        FirstLayerCategory firstLayerCategory,
        SecondLayerCategory secondLayerCategory,
        ThirdLayerCategory thirdLayerCategory,
        InferiorLayerCategory inferiorLayerCategory
) {

    public static CategoryVo from(CategoryInfoEntity categoryInfoEntity) {
        return new CategoryVo(
                categoryInfoEntity.getFirstLayerCategory(),
                categoryInfoEntity.getSecondLayerCategory(),
                categoryInfoEntity.getThirdLayerCategory(),
                categoryInfoEntity.getInferiorLayerCategory()
        );
    }
}
