package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

import java.util.Arrays;
import java.util.NavigableMap;

@Getter
public enum DeliveryFee {
    FREE("무료배송", true),
    NOT_FREE("배송비 필요", false),
    ;

    private final String desc;
    private final boolean isFree;

    DeliveryFee(String desc, boolean isFree) {
        this.desc = desc;
        this.isFree = isFree;
    }

    public static DeliveryFee findByIsFree(boolean isFree) {
        return isFree ? FREE : NOT_FREE;
    }
}
