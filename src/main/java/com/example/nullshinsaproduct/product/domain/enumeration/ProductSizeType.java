package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum ProductSizeType {
    TOP("상의 사이즈"),
    BOTTOM("하의 사이즈"),
    OUTER("아우터 사이즈"),
    DRESS("원피스 사이즈"),
    SKIRT("스커트 사이즈"),
    SHOES("신발 사이즈"),
    BAG("가방 사이즈"),
//    UNDER_WEAR("언더웨어 사이즈"),
    ;

    private final String desc;

    ProductSizeType(String desc) {
        this.desc = desc;
    }
}
