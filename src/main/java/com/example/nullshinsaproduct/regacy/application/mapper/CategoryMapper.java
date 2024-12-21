package com.example.nullshinsaproduct.regacy.application.mapper;

import com.example.nullshinsaproduct.regacy.application.dto.response.CategoryResponse;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.CategoryVo;

import java.util.Objects;

public class CategoryMapper {

    public static CategoryResponse mapProductDetailVoToRes(final CategoryVo categoryVo) {
        if (Objects.isNull(categoryVo)) {
            return null;
        }

        return new CategoryResponse(
                categoryVo.firstLayerCategory(),
                categoryVo.secondLayerCategory(),
                categoryVo.thirdLayerCategory(),
                categoryVo.inferiorLayerCategory()
        );
    }
}
