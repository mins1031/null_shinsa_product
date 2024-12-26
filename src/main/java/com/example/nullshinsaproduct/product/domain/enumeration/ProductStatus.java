package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum ProductStatus {
    TEMP("임시등록", 1),
    APPROVE("승인완료", 2),
    SELLING("판매중", 3),
    SOLD_OUT("솔드아웃", 4),
    SELL_END("판매종료", 5),
    ;

    private final String desc;
    private final int seq; // 순서

    ProductStatus(String desc, int seq) {
        this.desc = desc;
        this.seq = seq;
    }
}
