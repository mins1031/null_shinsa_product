package com.example.nullshinsaproduct.product.domain.vo;


import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import lombok.Getter;

@Getter
public class CategoryInfo {
    private final FirstLayerCategory firstLayerCategory;
    private final SecondLayerCategory secondLayerCategory;
    private final ThirdLayerCategory thirdLayerCategory;

    public CategoryInfo(FirstLayerCategory firstLayerCategory, SecondLayerCategory secondLayerCategory, ThirdLayerCategory thirdLayerCategory) {
        this.firstLayerCategory = firstLayerCategory;
        this.secondLayerCategory = secondLayerCategory;
        this.thirdLayerCategory = thirdLayerCategory;
    }

    public static CategoryInfo of(FirstLayerCategory firstLayerCategory, SecondLayerCategory secondLayerCategory, ThirdLayerCategory thirdLayerCategory) {
        return new CategoryInfo(firstLayerCategory, secondLayerCategory, thirdLayerCategory);
    }
}
