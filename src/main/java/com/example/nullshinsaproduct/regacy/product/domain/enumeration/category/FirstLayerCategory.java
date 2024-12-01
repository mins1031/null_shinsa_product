package com.example.nullshinsaproduct.regacy.product.domain.enumeration.category;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum FirstLayerCategory {
    WOMEN("여성", 10001),
    MEN("남성", 10002),
    ELECTRONICS("가전", 10003),

    ;

    private final String desc;
    private final int code;

    FirstLayerCategory(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public static boolean isClothes(FirstLayerCategory firstLayerCategory) {
        if (Objects.isNull(firstLayerCategory)) {
            return false;
        }

        return FirstLayerCategory.WOMEN.equals(firstLayerCategory) || FirstLayerCategory.MEN.equals(firstLayerCategory);
    }
}
