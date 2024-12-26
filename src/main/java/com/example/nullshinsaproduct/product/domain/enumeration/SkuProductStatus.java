package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum SkuProductStatus {
    TEMP("승인대기", 1),
    APPROVE("승인완료", 2),
    SELLING("판매중", 3),
    SOLD_OUT("솔드아웃", 4),

    ;

    private final String desc;
    private final int seq; // 순서

    SkuProductStatus(String desc, int seq) {
        this.desc = desc;
        this.seq = seq;
    }
}
