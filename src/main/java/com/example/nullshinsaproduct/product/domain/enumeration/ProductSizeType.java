package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum ProductSizeType {
    TOP("상의 사이즈"),
    BOTTOM("하의 사이즈"),
    UNDER_WEAR("언더웨어 사이즈"),
    ;

    private final String desc;

    ProductSizeType(String desc) {
        this.desc = desc;
    }
}
