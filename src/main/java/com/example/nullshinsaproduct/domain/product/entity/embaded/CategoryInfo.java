package com.example.nullshinsaproduct.domain.product.entity.embaded;

import com.example.nullshinsaproduct.domain.product.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.SecondLayerCategory;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryInfo {
    @Enumerated(EnumType.STRING)
    private FirstLayerCategory firstLayerCategory;
    @Enumerated(EnumType.STRING)
    private SecondLayerCategory secondLayerCategory;
    @Enumerated(EnumType.STRING)
    private ThirdLayerCategory thirdLayerCategory;
    @Enumerated(EnumType.STRING)
    private InferiorLayerCategory inferiorLayerCategory;

    public CategoryInfo(FirstLayerCategory firstLayerCategory, SecondLayerCategory secondLayerCategory, ThirdLayerCategory thirdLayerCategory, InferiorLayerCategory inferiorLayerCategory) {
        this.firstLayerCategory = firstLayerCategory;
        this.secondLayerCategory = secondLayerCategory;
        this.thirdLayerCategory = thirdLayerCategory;
        this.inferiorLayerCategory = inferiorLayerCategory;
    }
}
