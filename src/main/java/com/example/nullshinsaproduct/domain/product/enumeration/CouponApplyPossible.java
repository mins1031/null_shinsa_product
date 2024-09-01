package com.example.nullshinsaproduct.domain.product.enumeration;

import lombok.Getter;

@Getter
public enum CouponApplyPossible {
    POSSIBLE("쿠폰 사용가능 상품"),
    IMPOSSIBLE("쿠폰 사용불가 상품"),
    ;

    private final String desc;

    CouponApplyPossible(String desc) {
        this.desc = desc;
    }
}
