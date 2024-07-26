package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.common.domain.BaseEntity;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
    private String name;
    private int price;
    @Embedded
    private ProductDetailInfo productDetailInfo;
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;

    private long brandId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "seller_id")
//    private Brand brand;


    private Product(String name, int price, ProductDetailInfo productDetailInfo, CouponApplyPossible couponApplyPossible, long brandId) {
        this.name = name;
        this.price = price;
        this.productDetailInfo = productDetailInfo;
        this.couponApplyPossible = couponApplyPossible;
        this.brandId = brandId;
    }

    public static Product createProduct(String name, int price, ProductDetailInfo productDetailInfo, CouponApplyPossible couponApplyPossible, long brandId) {
        return new Product(name, price, productDetailInfo, couponApplyPossible, brandId);
    }
}
