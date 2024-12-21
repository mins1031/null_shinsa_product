package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum ProductType {
    CLOTHES("의류"),
    ELECTRONICS("가전"),

    ;

    private final String desc;

    ProductType(String desc) {
        this.desc = desc;
    }
}
