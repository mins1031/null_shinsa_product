package com.example.nullshinsaproduct.domain.product.enumeration.category;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum SecondLayerCategory {
    CLOTHES("의류", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20001),
    BAG("가방", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20002),
    SHOES("신발", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20003),
    ACC("액세서리", Set.of(FirstLayerCategory.MEN, FirstLayerCategory.WOMEN), 20004),

    ELECTRONICS("가전", Set.of(FirstLayerCategory.ELECTRONICS), 20005),

    ;

    private final String desc;
    private final Set<FirstLayerCategory> highCategories;
    private final int code;

    SecondLayerCategory(String desc, Set<FirstLayerCategory> highCategories, int code) {
        this.desc = desc;
        this.highCategories = highCategories;
        this.code = code;
    }

    public static List<SecondLayerCategory> getRelatedMidsWithHigh(FirstLayerCategory firstLayerCategory) {
        return Arrays.stream(SecondLayerCategory.values())
                .filter(value -> value.getHighCategories().contains(firstLayerCategory))
                .collect(Collectors.toList());
    }
}
