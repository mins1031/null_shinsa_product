package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import lombok.Getter;

@Getter
public class DiscountDetail {
    private DiscountApplyPossible discountApplyPossible;
    private int discountMinRate;
    private int discountMaxRate;
    private int discountRate;

    public DiscountDetail(DiscountApplyPossible discountApplyPossible, int discountMinRate, int discountMaxRate, int discountRate) {
        this.discountApplyPossible = discountApplyPossible;
        this.discountMinRate = discountMinRate;
        this.discountMaxRate = discountMaxRate;
        this.discountRate = discountRate;
    }

    public static DiscountDetail of(DiscountApplyPossible discountApplyPossible, int discountMinRate, int discountMaxRate, int discountRate) {
        return new DiscountDetail(
                discountApplyPossible,
                discountMinRate,
                discountMaxRate,
                discountRate
        );
    }

}
