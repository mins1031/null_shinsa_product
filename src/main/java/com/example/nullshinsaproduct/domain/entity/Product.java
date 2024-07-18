package com.example.nullshinsaproduct.domain.entity;

import com.example.nullshinsaproduct.common.domain.BaseEntity;
import com.example.nullshinsaproduct.domain.enumeration.CouponApplyPossible;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
    private String name;
    private int price;
    @Embedded
    private ProductDetailInfo productDetailInfo;
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Product(String name,
                   int price,
                   ProductDetailInfo productDetailInfo,
                   CouponApplyPossible couponApplyPossible,
                   Seller seller
    ) {
        this.name = name;
        this.price = price;
        this.productDetailInfo = productDetailInfo;
        this.couponApplyPossible = couponApplyPossible;
        this.seller = seller;
    }
}
