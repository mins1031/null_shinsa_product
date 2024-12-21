package com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded;

import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiscountDetailInEntity {
    @Enumerated(EnumType.STRING)
    private DiscountApplyPossible discountApplyPossible;
    private int discountMinRate;
    private int discountMaxRate;

    public DiscountDetailInEntity(DiscountApplyPossible discountApplyPossible, int discountMinRate, int discountMaxRate) {
        this.discountApplyPossible = discountApplyPossible;
        this.discountMinRate = discountMinRate;
        this.discountMaxRate = discountMaxRate;
    }
}
