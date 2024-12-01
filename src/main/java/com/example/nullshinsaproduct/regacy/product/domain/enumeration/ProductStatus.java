package com.example.nullshinsaproduct.regacy.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum ProductStatus {
    TEMP("임시등록"),
    SELLING("판매중"),
    SOLD_OUT("솔드아웃"),
    SELL_END("판매종료"),
    ;

    private final String desc;

    ProductStatus(String desc) {
        this.desc = desc;
    }
}
