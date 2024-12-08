package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import lombok.Getter;

@Getter
public class DiscountDetail {
    private DiscountApplyPossible discountApplyPossible;
    private int discountMinRate;
    private int discountMaxRate;

    private DiscountDetail(DiscountApplyPossible discountApplyPossible, int discountMinRate, int discountMaxRate) {
        this.discountApplyPossible = discountApplyPossible;
        this.discountMinRate = discountMinRate;
        this.discountMaxRate = discountMaxRate;
    }

    public static DiscountDetail of(DiscountApplyPossible discountApplyPossible, int discountMinRate, int discountMaxRate) {
        return new DiscountDetail(
                discountApplyPossible,
                discountMinRate,
                discountMaxRate
        );
    }

}
