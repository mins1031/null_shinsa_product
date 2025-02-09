package com.example.nullshinsaproduct.sale.domain;

import lombok.Getter;

@Getter
public enum SaleStatus {
    WAIT("세일 대기"),
    IN_PROGRESSING("세일 진행중"),
    FINISH("종료된 세일")
    ;

    private final String desc;

    SaleStatus(String desc) {
        this.desc = desc;
    }
}
