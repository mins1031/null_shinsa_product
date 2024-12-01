package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum DiscountApplyPossible {
    POSSIBLE("할인 가능"),
    IMPOSSIBLE("할인 불가능"),
    ;

    private final String desc;

    DiscountApplyPossible(String desc) {
        this.desc = desc;
    }
}
