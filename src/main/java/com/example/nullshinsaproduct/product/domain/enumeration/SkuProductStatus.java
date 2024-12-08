package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum SkuProductStatus {
    SELLING("판매중"),
    SOLD_OUT("솔드아웃"),

    ;

    private final String desc;

    SkuProductStatus(String desc) {
        this.desc = desc;
    }
}
