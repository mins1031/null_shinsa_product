package com.example.nullshinsaproduct.domain.product.enumeration;

import lombok.Getter;

@Getter
public enum DeliveryFee {
    FREE("무료배송"),
    NOT_FREE("배송비 필요"),
    ;

    private final String desc;

    DeliveryFee(String desc) {
        this.desc = desc;
    }
}
