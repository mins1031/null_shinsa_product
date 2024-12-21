package com.example.nullshinsaproduct.product.domain.enumeration.category;

import lombok.Getter;

import java.util.Set;

@Getter
public enum SecondLayerCategory {
    OUTER("아우터", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20001),
    TOP("상의", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20002),
    BOTTOM("하의", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20003),
    DRESS_SKIRT("원피스/스커트", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20004),
    BAG("가방", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20005),
    SHOES("신발", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20006),


    ;

    private final String desc;
    private final Set<FirstLayerCategory> highCategories;
    private final int code;

    SecondLayerCategory(String desc, Set<FirstLayerCategory> highCategories, int code) {
        this.desc = desc;
        this.highCategories = highCategories;
        this.code = code;
    }

}
